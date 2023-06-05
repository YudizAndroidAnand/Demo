package com.example.myapplication.json.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.R
import me.relex.circleindicator.CircleIndicator

@Suppress("DEPRECATION")
class ShowProductDataActivity : AppCompatActivity(){
    lateinit var producttitle :TextView
    lateinit var productdescription :TextView
    lateinit var productprice :TextView
    lateinit var productDiscountPercentage :TextView
    lateinit var productrating :TextView
    lateinit var productstock :TextView
    lateinit var productbrand :TextView
    lateinit var productcategory :TextView
    lateinit var viewpage : ViewPager
    lateinit var indicator: CircleIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_product_data)
        producttitle = findViewById(R.id.textview_product_name)
        productdescription = findViewById(R.id.textview_product_description)
        productprice = findViewById(R.id.textview_product_price)
        productDiscountPercentage = findViewById(R.id.textview_product_discountPercentage)
        productrating = findViewById(R.id.textview_product_rating)
        productstock = findViewById(R.id.textview_product_stock)
        productbrand = findViewById(R.id.textview_product_brand)
        productcategory = findViewById(R.id.textview_product_category)
        viewpage = findViewById(R.id.viewPage_product)

        val b = intent.getSerializableExtra("keys") as ProductData
        producttitle.text = b.title
        productdescription.text = b.description
        productprice.text = b.price.toString()
        productDiscountPercentage.text = b.discountPercentage.toString()
        productstock.text = b.stock.toString()
        productbrand.text = b.brand
        productcategory.text = b.category
        val imageAdapter = ImageAdapter(this,b.images)
        viewpage.adapter =  imageAdapter
        findViewById<Button>(R.id.button_back).setOnClickListener {
            startActivity(Intent(this,GetDataActivity::class.java))
        }
    }
}
