package com.example.myapplication.json.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract.Root
import android.view.LayoutInflater
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityShowProductDataBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ShowProductDataActivity : AppCompatActivity(){
    lateinit var viewpage : ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityShowProductDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        findViewById<Button>(R.id.button_back).setOnClickListener {
            startActivity(Intent(this, GetDataActivity::class.java))
        }
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitAPI::class.java)
        val call = retrofit.getProduct()
        call.enqueue(object : Callback<UserDataProduct> {
            override fun onResponse(call: Call<UserDataProduct>, response: Response<UserDataProduct>) {
                if (response.body() != null){
                    val b : Int = intent.getIntExtra("keys",0)
                    val mainList = response.body()!!.productData
                    val a = mainList[b]
                    binding.productVariable.description = a.description
                }

//              productprice.text = b.price.toString()
//              productDiscountPercentage.text = b.discountPercentage.toString()
//              productstock.text = b.stock.toString()
//              productbrand.text = b.brand
//              productcategory.text = b.category
//              val imageAdapter = ImageAdapter(this,b.images)
//              viewpage.adapter =  imageAdapter
            }
            override fun onFailure(call: Call<UserDataProduct>, t: Throwable) {
            }
        })
    }
}

