package com.example.myapplication.Dialog
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.R
import java.util.*
class DialogBoxBookingMain : AppCompatActivity() {
    lateinit var selectedFromDate: Calendar
    lateinit var selectedToDate: Calendar
    lateinit var selectedTime: Calendar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_box_booking_main)
        findViewById<Button>(R.id.btnEnterData).setOnClickListener {
            DialogBoxBooking().show(supportFragmentManager, "MyCustomFragment")
            showDatePickerDialog(true)
        }
    }
    fun showDatePickerDialog(isFromDate: Boolean) {
        val textview : TextView = findViewById(R.id.textview)
        val currentDate = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, monthOfYear, dayOfMonth ->
                currentDate.set(year, monthOfYear, dayOfMonth)

                if(isFromDate) {
                    selectedFromDate = currentDate
                    textview.setText(formatDate(selectedFromDate))
                } else {
                    selectedToDate = currentDate
                    textview.setText(formatDate(selectedToDate))
                }
            },
            currentDate.get(Calendar.YEAR),
            currentDate.get(Calendar.MONTH),
            currentDate.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show()
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