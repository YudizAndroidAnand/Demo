package com.example.myapplication.Json.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.R

class ShowProductData : AppCompatActivity(){
    lateinit var title :TextView
    lateinit var description :TextView
    lateinit var price :TextView
    lateinit var discountPercentage :TextView
    lateinit var rating :TextView
    lateinit var stock :TextView
    lateinit var brand :TextView
    lateinit var category :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_product_data)
        title = findViewById(R.id.textview_title12)
        description = findViewById(R.id.textview_description)
        price = findViewById(R.id.textview_price)
        discountPercentage = findViewById(R.id.textview_discountPercentage)
        rating = findViewById(R.id.textview_rating)
        stock = findViewById(R.id.textview_stock)
        brand = findViewById(R.id.textview_brand)
        category = findViewById(R.id.textview_category)
        val b = intent.getStringExtra("key21")
        title.text = b
    }
}