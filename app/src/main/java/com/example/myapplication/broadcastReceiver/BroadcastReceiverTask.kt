package com.example.myapplication.broadcastReceiver

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class BroadcastReceiverTask : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receiver_task2)
        findViewById<Button>(R.id.btn1).setOnClickListener {
            startActivity(Intent(this,BroadcastReceiverActivity::class.java))
        }
        findViewById<Button>(R.id.btn2).setOnClickListener {
            startActivity(Intent(this,BroadcastReceiverCustomActivity::class.java))
        }
    }
}