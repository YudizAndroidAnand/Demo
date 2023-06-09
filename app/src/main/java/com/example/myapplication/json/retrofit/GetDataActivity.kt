package com.example.myapplication.json.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.json.dataParsing.body
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetDataActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    lateinit var progressBar: ProgressBar
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
                progressBar = findViewById(R.id.progress_circular)
                progressBar.visibility = View.GONE
                newRecyclerView = findViewById(R.id.recyclerview_product)
                val myAdapter = response.body()
                    ?.let {
                        AdapterRetrofit(this@GetDataActivity, it.productData) { body ->
                            val intent = Intent(this@GetDataActivity, ShowProductDataActivity::class.java)
                            intent.putExtra("keys", body.id)
                            startActivity(intent)
                            finish()
                        }
                    }
                newRecyclerView.adapter = myAdapter
            }
            override fun onFailure(call: Call<UserDataProduct>, t: Throwable) {
                Toast.makeText(this@GetDataActivity, "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}


