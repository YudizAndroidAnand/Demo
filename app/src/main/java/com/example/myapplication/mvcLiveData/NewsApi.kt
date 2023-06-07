package com.example.myapplication.mvcLiveData

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything?apiKey=9052eadf429344b7926a2d7a0c8c25bc")
    suspend fun getNews(@Query("q")topicName : String) : Response<NewRes>
}