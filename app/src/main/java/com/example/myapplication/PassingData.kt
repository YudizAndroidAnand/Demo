package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.Fragment.CommunicteTwoFragment
import com.example.myapplication.Fragment.FragmentForHome

class PassingData : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passing_data)
        findViewById<Button>(R.id.backbtn).setOnClickListener {
            startActivity(Intent(this,FragmentForHome::class.java))
        }
    }
}