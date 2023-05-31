package com.example.myapplication.Json.retrofit

import com.google.gson.annotations.SerializedName

data class UserDataProduct(
    @SerializedName("products")
    val productData: ArrayList<ProductData>,
    val total : Int,
    val skip : Int,
    val limit : Int
)
