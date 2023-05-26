package com.example.myapplication.DemoProject.TaskTable

import android.accounts.AuthenticatorDescription
import android.icu.text.CaseMap.Title
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true )
    val id : Int,
    val title: String,
    val description: String)

