package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

class DataBindingTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // val binding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_data_binding_test, false)
        setContentView(R.layout.activity_data_binding_test)
    }
}
