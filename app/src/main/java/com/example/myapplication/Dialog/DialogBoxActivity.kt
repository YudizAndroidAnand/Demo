package com.example.myapplication.Dialog
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myapplication.R

open class DialogBoxActivity : AppCompatActivity() {

     lateinit var fromDateEditText: EditText
     lateinit var toDateEditText: EditText
     lateinit var timeEditText: EditText
     lateinit var submitButton: Button
     lateinit var selectedFromDate: Calendar
     lateinit var selectedToDate: Calendar
     lateinit var selectedTime: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_box)

        fromDateEditText = findViewById(R.id.fromDateEditText)
        toDateEditText = findViewById(R.id.toDateEditText)
        timeEditText = findViewById(R.id.timeEditText)
        submitButton = findViewById(R.id.submitButton)

        findViewById<Button>(R.id.btnSub).setOnClickListener {


        }

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
                startActivity(Intent(this,DialogDateTime::class.java))
                showConfirmationDialog()
            }
        }
    }

    private fun showDatePickerDialog(isFromDate: Boolean) {
        val currentDate = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, monthOfYear, dayOfMonth ->
                currentDate.set(year, monthOfYear, dayOfMonth)

                if(isFromDate) {
                    selectedFromDate = currentDate
                    fromDateEditText.setText(formatDate(selectedFromDate))
                } else {
                    selectedToDate = currentDate
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

    private fun showConfirmationDialog()  {
        val obj = DialogDateTime()
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Confirmation")
        alertDialogBuilder.setMessage("Are you sure to submit the details?")
        alertDialogBuilder.setPositiveButton("Yes") { _, _ ->
           // textFormData = findViewById(R.id.textviewFormData)
            val result = "From Date: ${formatDate(selectedFromDate)}\n" +
                    "To Date: ${formatDate(selectedToDate)}\n" +
                    "Time: ${formatTime(selectedTime)}"
           // obj.textFormData.text = result
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

    fun formatDate(calendar: Calendar): String {
        val dateFormat = android.text.format.DateFormat.getDateFormat(this)
        return dateFormat.format(calendar.time)
    }

    fun formatTime(calendar: Calendar): String {
        val timeFormat = android.text.format.DateFormat.getTimeFormat(this)
        return timeFormat.format(calendar.time)
    }
}




