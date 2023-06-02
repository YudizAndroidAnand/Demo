package com.example.myapplication.Json.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.R
import com.squareup.picasso.Picasso

class ShowProductData : AppCompatActivity(){
    lateinit var producttitle :TextView
    lateinit var productdescription :TextView
    lateinit var productprice :TextView
    lateinit var productdiscountPercentage :TextView
    lateinit var productrating :TextView
    lateinit var productstock :TextView
    lateinit var productbrand :TextView
    lateinit var productcategory :TextView
    lateinit var productImage : ImageView
    lateinit var viewpage : ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_product_data)
        producttitle = findViewById(R.id.textview_title12)
        productdescription = findViewById(R.id.textview_description)
        productprice = findViewById(R.id.textview_price)
        productdiscountPercentage = findViewById(R.id.textview_discountPercentage)
        productrating = findViewById(R.id.textview_rating)
        productstock = findViewById(R.id.textview_stock)
        productbrand = findViewById(R.id.textview_brand)
        productcategory = findViewById(R.id.textview_category)
        productImage = findViewById(R.id.imageview_big_product)
        viewpage = findViewById(R.id.viewPage_product)

        val b = intent.getSerializableExtra("keys") as ProductData
        producttitle.text = b.title
        productdescription.text = b.description
        productprice.text = b.price.toString()
        productdiscountPercentage.text = b.discountPercentage.toString()
        productstock.text = b.stock.toString()
        productbrand.text = b.brand
        productcategory.text = b.category
        Picasso.get().load(b.thumbnail).into(productImage)
        val imageAdapter = ImageAdapter(this,b.images)
        viewpage.adapter =  imageAdapter
    }
}
