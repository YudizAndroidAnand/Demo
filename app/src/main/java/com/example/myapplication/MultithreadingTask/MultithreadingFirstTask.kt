package com.example.myapplication.MultithreadingTask

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MultithreadingFirstTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multithreading)
        val textviewAddNumber : TextView = findViewById(R.id.textviewAddTwoNumber)
        val firstnumber = 5
        val Secondnumber = 2
        val thread: Thread = object : Thread() {
            override fun run() {
                try {
                        runOnUiThread {
                            val c = firstnumber+Secondnumber
                            textviewAddNumber.text = c.toString()
                    }
                } catch (e: InterruptedException) {
                }
            }
        }
        thread.start()
    }
}