package com.example.myapplication.MultithreadingTask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.R

class MultithreadingSecondTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multithreading_second_task)
        val textFirst: TextView = findViewById(R.id.textview_first_number)
        val textSecond: TextView = findViewById(R.id.textview_second_number)
        val number = 50
        val num = 10

        val thread: Thread = object : Thread() {
            override fun run() {
               try {
                   runOnUiThread {
                        val result = number + num
                       textFirst.text = result.toString()
                   }
               }
               catch (e: InterruptedException){

               }
            }
        }
        thread.start()
        for (i in 1..10000){
            val threadOther: Thread = object : Thread() {
                override fun run() {
                    try {Thread.sleep(2000)
                        runOnUiThread {
//                        val newResult = 110 + num
//                        textSecond.text = newResult.toString()
                            textSecond.text = i.toString()
                        }
                    }
                    catch (e: InterruptedException){
                    }
                }
            }
            threadOther.start()
        }
    }
}



