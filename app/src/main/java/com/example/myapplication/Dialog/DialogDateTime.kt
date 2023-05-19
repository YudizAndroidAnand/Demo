package com.example.myapplication.Dialog

import android.annotation.SuppressLint
import android.app.DatePickerDialog
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
     var fromDateEditText: EditText = findViewById(R.id.fromDateEditText)
     var toDateEditText: EditText = findViewById(R.id.toDateEditText)
     var timeEditText: EditText = findViewById(R.id.timeEditText)
     var submitButton: Button = findViewById(R.id.submitButton)
     lateinit var selectedFromDate: Calendar
     lateinit var selectedToDate: Calendar
     lateinit var selectedTime: Calendar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_date_time)

    }

}