package com.example.myapplication.MainScreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.*
import com.example.myapplication.BroadcastReceiver.BroadcastReceiverTask

class ActivityAllProject2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_project2)
        findViewById<Button>(R.id.btn14).setOnClickListener {
            startActivity(Intent(this, IntentFilterActivity::class.java))
        }
        findViewById<Button>(R.id.btn15).setOnClickListener {
            startActivity(Intent(this, BroadcastReceiverTask::class.java))
        }
        findViewById<Button>(R.id.btn16).setOnClickListener {
            startActivity(Intent(this, WorkManagerActivity::class.java))
        }
        findViewById<Button>(R.id.btn17).setOnClickListener {
            startActivity(Intent(this, SaveFileActivity::class.java))
        }
        findViewById<Button>(R.id.btn18).setOnClickListener {
            startActivity(Intent(this, AnimationsActivity::class.java))
        }
        findViewById<Button>(R.id.btn19).setOnClickListener {
            startActivity(Intent(this,MultithreadingActivity::class.java))
        }
    }
}