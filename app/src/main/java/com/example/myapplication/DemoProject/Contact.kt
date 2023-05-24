package com.example.myapplication.DemoProject

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val description:String)
