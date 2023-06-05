package com.example.myapplication.multiThreadingTask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class MultithreadingTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multithreading_task)
        findViewById<Button>(R.id.buttonTask1).setOnClickListener {
            startActivity(Intent(this,MultithreadingFirstTask::class.java))
        }
        findViewById<Button>(R.id.buttonTask2).setOnClickListener {
            startActivity(Intent(this,MultithreadingSecondTask::class.java))
        }
        findViewById<Button>(R.id.buttonTask3).setOnClickListener {
            startActivity(Intent(this,MultithreadingThirdTask::class.java))
        }
        findViewById<Button>(R.id.buttonTask4).setOnClickListener {
            startActivity(Intent(this,MultithreadingFourthTask::class.java))
        }
    }
}