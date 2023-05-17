package com.example.myapplication

data class filedata(val id:String,
                    val name:String,
                    val type:String,
                    val url:String,
                    var downloadedUri:String?=null,
                    var isDownloading:Boolean = false,)
