package com.example.myapplication.Json.Dataparsing

import com.google.gson.annotations.SerializedName
import org.json.JSONArray

data class JsonData(
    var id: Int,
    var title: String,
    var body: String,
    var userId: Int,
    var country: JSONArray,
    var number: Int,
)
    @SerializedName("id")
    var id : Int = 0

    @SerializedName("title")
    var title : String = ""

    @SerializedName("body")
    var body : String = ""

    @SerializedName("userId")
    var userId : Int = 0

    @SerializedName("country")
    var country : JSONArray = JSONArray()

    @SerializedName("number")
    var numbaer : Int = 0
