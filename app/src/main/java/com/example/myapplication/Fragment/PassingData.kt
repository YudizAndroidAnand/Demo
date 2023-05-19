package com.example.myapplication.Fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class PassingData : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passing_data)
        findViewById<Button>(R.id.backbtn).setOnClickListener {
            startActivity(Intent(this,FragmentForHome::class.java))
        }
    }
}