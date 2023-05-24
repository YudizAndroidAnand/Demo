package com.example.myapplication.MultithreadingTask

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R

class Multithreadingthired : AppCompatActivity() {
    private lateinit var counterTextView: TextView
    private lateinit var startButton: Button
    private var task: CounterTask? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multithreadingthired)
        counterTextView = findViewById(R.id.textview_counter)
        startButton = findViewById(R.id.button_start)

        startButton.setOnClickListener {
            task = CounterTask()
            task?.execute()
        }
    }

    private inner class CounterTask : AsyncTask<Void, Int, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            var counter = 0
            for (i in 1..10) {
                counter = i
                publishProgress(counter)
                if (counter == 10) {
                    isCancelled
                    break
                }
                Thread.sleep(1000) // Simulate some work being done

            }
            return null
        }
        override fun onProgressUpdate(vararg values: Int?) {
            val counterValue = values[0] ?: 0
            counterTextView.text = "Counter: $counterValue"
        }
        override fun onPostExecute(result: Void?) {
            Toast.makeText(applicationContext, "Task Completed", Toast.LENGTH_SHORT).show()
        }
    }
}
