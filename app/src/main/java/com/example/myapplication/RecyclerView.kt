package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.view.size
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class RecyclerView : AppCompatActivity() {

     lateinit var newrecyclerView: RecyclerView
    private lateinit var newlist: MutableList<userdata>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        newlist = mutableListOf(userdata("anand","7600740075","anand@gmail.com"),
            userdata("anand1","7600740075","anand@gmail.com"),
            userdata("anand2","7600740075","anand@gmail.com"),
            userdata("anand3","7600740075","anand@gmail.com"),
            userdata("anand4","7600740075","anand@gmail.com"),
            userdata("anand5","7600740075","anand@gmail.com"),
            userdata("anand6","7600740075","anand@gmail.com"),
            userdata("anand7","7600740075","anand@gmail.com"),
            userdata("anand8","7600740075","anand@gmail.com"),
            userdata("anand9","7600740075","anand@gmail.com"),
            userdata("anand10","7600740075","anand@gmail.com"),
            userdata("anand11","7600740075","anand@gmail.com"),
            userdata("anand12","7600740075","anand@gmail.com"),
            userdata("anand13","7600740075","anand@gmail.com"),
            userdata("anand14","7600740075","anand@gmail.com"),
            userdata("anand15","7600740075","anand@gmail.com"),
            userdata("anand16","7600740075","anand@gmail.com"),
            userdata("anand17","7600740075","anand@gmail.com"))

        newrecyclerView = findViewById(R.id.recyclerview)
        newrecyclerView.layoutManager = LinearLayoutManager(this)
        newrecyclerView.size
        newrecyclerView.adapter = adapter(newlist)

    }
}


