package com.example.myapplication.BroadcastReceiver

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R

class BroadcastReceiverCustomActivity : AppCompatActivity() {
    val battery = BatteryChangeCustom()
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast2)
        val view = LayoutInflater.from(this).inflate(R.layout.broadcastcustomnotification, null, false)
        view.findViewById<Button>(R.id.btn1).setOnClickListener {
            onStart()
        }
        view.findViewById<Button>(R.id.btn2).setOnClickListener{
            onDestroy()
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(battery)
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(battery,filter)
    }
}