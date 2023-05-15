package com.example.myapplication
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class DialogBoxActivity : AppCompatActivity() {

    private lateinit var fromDateEditText: EditText
    private lateinit var toDateEditText: EditText
    private lateinit var timeEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var selectedFromDate: Calendar
    private lateinit var selectedToDate: Calendar
    private lateinit var selectedTime: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_box)

        fromDateEditText = findViewById(R.id.fromDateEditText)
        toDateEditText = findViewById(R.id.toDateEditText)
        timeEditText = findViewById(R.id.timeEditText)
        submitButton = findViewById(R.id.submitButton)

        fromDateEditText.setOnClickListener {
            showDatePickerDialog(true)
        }

        toDateEditText.setOnClickListener {
            showDatePickerDialog(false)
        }

        timeEditText.setOnClickListener {
            showTimePickerDialog()
        }

        submitButton.setOnClickListener {
            if (validateInputs()) {
                showConfirmationDialog()
            }
        }
    }

    private fun showDatePickerDialog(isFromDate: Boolean) {
        val currentDate = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, monthOfYear, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)

                if (isFromDate) {
                    selectedFromDate = selectedDate
                    fromDateEditText.setText(formatDate(selectedFromDate))
                } else {
                    selectedToDate = selectedDate
                    toDateEditText.setText(formatDate(selectedToDate))
                }
            },
            currentDate.get(Calendar.YEAR),
            currentDate.get(Calendar.MONTH),
            currentDate.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show()
    }

    private fun showTimePickerDialog() {
        val currentTime = Calendar.getInstance()
        val timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                selectedTime = Calendar.getInstance()
                selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
                selectedTime.set(Calendar.MINUTE, minute)
                timeEditText.setText(formatTime(selectedTime))
            },
            currentTime.get(Calendar.HOUR_OF_DAY),
            currentTime.get(Calendar.MINUTE),
            false
        )
        timePickerDialog.show()
    }

    private fun showConfirmationDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Confirmation")
        alertDialogBuilder.setMessage("Are you sure to submit the details?")
        alertDialogBuilder.setPositiveButton("Yes") { _, _ ->
            val resultTextView: TextView = findViewById(R.id.resultTextView)
            val result = "From Date: ${formatDate(selectedFromDate)}\n" +
                    "To Date: ${formatDate(selectedToDate)}\n" +
                    "Time: ${formatTime(selectedTime)}"
            resultTextView.text = result
        }
        alertDialogBuilder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun validateInputs(): Boolean {
        val fromDateText = fromDateEditText.text.toString().trim()
        val toDateText = toDateEditText.text.toString().trim()
        val timeText = timeEditText.text.toString().trim()

        if (fromDateText.isEmpty()) {
            fromDateEditText.error = "Please select a From Date"
            return false
        }

        if (toDateText.isEmpty()) {
            toDateEditText.error = "Please select a To Date"
            return false
        }

        if (timeText.isEmpty()) {
            timeEditText.error = "Please select a Time"
            return false
        }

        val fromDate = convertToDate(fromDateText)
        val toDate = convertToDate(toDateText)

        if (fromDate == null || toDate == null) {
            // Invalid date format
            return false
        }

        if (fromDate.after(toDate)) {
            toDateEditText.error = "To Date must be after From Date"
            return false
        }

        return true
    }

    private fun convertToDate(dateText: String): Date? {
        val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return try {
            format.parse(dateText)
        } catch (e: ParseException) {
            null
        }
    }

    private fun formatDate(calendar: Calendar): String {
        val dateFormat = android.text.format.DateFormat.getDateFormat(this)
        return dateFormat.format(calendar.time)
    }

    private fun formatTime(calendar: Calendar): String {
        val timeFormat = android.text.format.DateFormat.getTimeFormat(this)
        return timeFormat.format(calendar.time)
    }
}