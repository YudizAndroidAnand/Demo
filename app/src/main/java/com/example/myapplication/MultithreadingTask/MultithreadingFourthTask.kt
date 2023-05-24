package com.example.myapplication.MultithreadingTask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MultithreadingFourthTask : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multithreading_fourth_task)
        resultTextView = findViewById(R.id.textview_result)

        CoroutineScope(Dispatchers.Main).launch {
            val result = performOperation()
            displayResult(result)
        }
    }
    private fun displayResult(result: String) {
        resultTextView.text = result
    }

    private suspend fun performOperation(): String{
        delay(10000)
        return "Task completed!!"
    }
}



