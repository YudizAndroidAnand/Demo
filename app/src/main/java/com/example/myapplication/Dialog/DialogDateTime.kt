package com.example.myapplication.Dialog

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.R
import java.util.*

class DialogDateTime : AppCompatActivity() {
    lateinit var textFormData : TextView
    lateinit var textToData : TextView
    lateinit var textTime : TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_date_time)
        findViewById<Button>(R.id.btnBoolTicket).setOnClickListener {
            startActivity(Intent(this, DialogBoxActivity::class.java))
        }
    }
}