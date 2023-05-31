package com.example.myapplication.Json.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI{
    @GET("products")
    fun getProduct(): Call<UserDataProduct>
}
