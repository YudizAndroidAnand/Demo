package com.example.myapplication.mainScreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.*
import com.example.myapplication.broadcastReceiver.BroadcastReceiverTask
import com.example.myapplication.DemoProject.LoginActivity
import com.example.myapplication.json.dataParsing.JsonPassingActivity
import com.example.myapplication.json.retrofit.GetDataActivity
import com.example.myapplication.SaveFileActivity
import com.example.myapplication.multiThreadingTask.MultithreadingTask
import com.example.myapplication.mvcLiveData.LiveDataActivity
import com.example.myapplication.workManager.WorkManagerActivity

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
            startActivity(Intent(this, MultithreadingTask::class.java))
        }
        findViewById<Button>(R.id.btn20).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        findViewById<Button>(R.id.btn21).setOnClickListener {
            startActivity(Intent(this, JsonPassingActivity::class.java))
        }
        findViewById<Button>(R.id.btn22).setOnClickListener {
            startActivity(Intent(this, MapActivity::class.java))
        }
        findViewById<Button>(R.id.btn23).setOnClickListener {
            startActivity(Intent(this, GetDataActivity::class.java))
        }
        findViewById<Button>(R.id.btn24).setOnClickListener {
            startActivity(Intent(this, LiveDataActivity::class.java))
        }
    }
}