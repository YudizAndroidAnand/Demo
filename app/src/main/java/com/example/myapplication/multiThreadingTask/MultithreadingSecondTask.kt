package com.example.myapplication.multiThreadingTask

import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MultithreadingSecondTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multithreading_second_task)
        val textViewResultFirst : TextView = findViewById(R.id.textview_number)
        val textViewResultSecond : TextView = findViewById(R.id.textview_number1)
        val number = 10
        val number2 = 20
        val handler = Handler()
        Thread {
            val result = number + number2
            handler.post {
                textViewResultFirst.text = result.toString()
            }
            Thread {
                handler.post {
                    val res = result * number2
                    textViewResultSecond.text = res.toString()
                }
            }.start()
        }.start()
    }
}




