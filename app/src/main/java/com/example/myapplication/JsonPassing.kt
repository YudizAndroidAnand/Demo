package com.example.myapplication

data class JsonPassing(
    val id : Int = 0,
    val name : String = "",
    val username : String = "",
    val email : String = "",
    val address : String = "",
    val phone : String = "",
    val website : String = "",
)
data class Address(val street : String = "",
                   val suite : String = "",
                   val city : String = "",
                   val zipcode : String = "",
                   val geo : String = "")
data class Geo(val lat : String = "",
               val lng : String = "",
               val company : String = "",)
data class Company(val name : String = "",
                   val catchPhrase : String = "",
                   val bs : String = "",)

