package com.example.myapplication.Dialog

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.R
import java.util.*

class DialogDateTime : AppCompatActivity() {

    private lateinit var fromDatetxt: EditText
    private lateinit var toDatetxt: EditText
    private lateinit var timetxt: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_date_time)
        findViewById<Button>(R.id.btnclickkme).setOnClickListener {
            val dialog = Dialog(this)
            val dialogView =  dialog.setContentView(R.layout.activity_dialog_box)
            fromDatetxt =dialog.findViewById(R.id.fromDateEditText)
            toDatetxt = dialog.findViewById(R.id.toDateEditText)
            timetxt = dialog.findViewById(R.id.timeEditText)
            val submitbtn = dialog.findViewById<Button>(R.id.submitButton)
            val cancelbtn = dialog.findViewById<Button>(R.id.cancelButton)
            dialog.show()

            fromDatetxt.setOnClickListener {
                val currentDate = Calendar.getInstance()
                val datePickerDialog = DatePickerDialog(this, { _, year, monthOfYear, dayOfMonth ->
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(year, monthOfYear, dayOfMonth)
                    if (true) {
                        val  selectedFromDate = selectedDate
                        fromDatetxt.setText(formatDate(selectedFromDate))
                    } else {
                        val  selectedToDate = selectedDate
                        toDatetxt.setText(formatDate(selectedToDate))
                    }
                },
                    currentDate.get(Calendar.YEAR),
                    currentDate.get(Calendar.MONTH),
                    currentDate.get(Calendar.DAY_OF_MONTH)
                )
                datePickerDialog.datePicker.minDate=System.currentTimeMillis()
                datePickerDialog.show()
            }

            toDatetxt.setOnClickListener {
                val currentDate = Calendar.getInstance()
                val datePickerDialog = DatePickerDialog(this, { _, year, monthOfYear, dayOfMonth ->
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(year, monthOfYear, dayOfMonth)

                    if (false) {
                        val  selectedFromDate = selectedDate
                        fromDatetxt.setText(formatDate(selectedFromDate))
                    } else {
                        val  selectedToDate = selectedDate
                        toDatetxt.setText(formatDate(selectedToDate))
                    }
                },
                    currentDate.get(Calendar.YEAR),
                    currentDate.get(Calendar.MONTH),
                    currentDate.get(Calendar.DAY_OF_MONTH)
                )

                datePickerDialog.show()
            }

            timetxt.setOnClickListener {
                val currentTime = Calendar.getInstance()
                val timePickerDialog = TimePickerDialog(
                    this,
                    { _, hourOfDay, minute ->
                        val selectedTime = Calendar.getInstance()
                        selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
                        selectedTime.set(Calendar.MINUTE, minute)

                        timetxt.setText(formatTime(selectedTime))
                    },
                    currentTime.get(Calendar.HOUR_OF_DAY),
                    currentTime.get(Calendar.MINUTE),
                    false
                )
                timePickerDialog.show()
            }

            submitbtn.setOnClickListener {
                if(isValid()) {
                    showConfirmationDialog()
                }
            }
            cancelbtn.setOnClickListener { dialog.dismiss() }
        }

    }
    private fun isValid(): Boolean {
        val fromDateText = fromDatetxt.text.toString().trim()
        val toDateText = toDatetxt.text.toString().trim()
        val timeText = timetxt.text.toString().trim()

        if (fromDateText.isEmpty() && toDateText.isEmpty() && timeText.isEmpty()) {
            fromDatetxt.error = "Please select a From Date"
            return false
        }
        return true
    }

    private fun showConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        val dialog = builder.create()
        builder.setTitle("Confirmation")
        builder.setMessage("Are you sure to submit the details?")
        val result = "From Date: ${fromDatetxt.text}\n"+"To Date: ${toDatetxt.text}\n"+"Time: ${timetxt.text}"

        val dataTextView: TextView = findViewById(R.id.tvshowdata)
        builder.setPositiveButton("OK") { dialog,_ ->
            dataTextView.text = result
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
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