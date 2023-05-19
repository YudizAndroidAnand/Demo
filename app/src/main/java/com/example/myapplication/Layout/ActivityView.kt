package com.example.myapplication.Layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R

class ActivityView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
    }
}