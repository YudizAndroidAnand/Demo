package com.example.myapplication.Json.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetData : AppCompatActivity() {

    private lateinit var newrecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_data)

        getData()

    }
    private fun getData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitAPI::class.java)
        val call = retrofit.getProduct()

        call.enqueue(object : Callback<UserDataProduct> {
            override fun onResponse(call: Call<UserDataProduct>, response: Response<UserDataProduct>)
            {

                newrecyclerView = findViewById(R.id.recyclerview_product)
                val myAdapter = response.body()
                    ?.let { AdapterRetrofit(this@GetData, it.productData) }
            }
            override fun onFailure(call: Call<UserDataProduct>, t: Throwable) {
                Toast.makeText(this@GetData, "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}