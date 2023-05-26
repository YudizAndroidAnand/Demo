package com.example.myapplication.DemoProject.UserDataTable

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserData")
data class UserSignupData(
    @PrimaryKey(autoGenerate = true )
    val name : String,
    val email : String,
    val mobileNumber : Long,
    val password : String)
