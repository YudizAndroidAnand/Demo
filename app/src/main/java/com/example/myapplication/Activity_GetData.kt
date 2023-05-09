package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity_GetData : AppCompatActivity() {
    lateinit var txt1 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_data)
        val home_fragment = Fragment_Home_Fragmate()
        txt1 = findViewById(R.id.textview)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framerootlayout,home_fragment)
                .addToBackStack("home_fragment")
                .commit()
        }
        val intent = intent
        val stringTxt = intent.getStringArrayExtra("xx")
        txt1.text =
    }
}