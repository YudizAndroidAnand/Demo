package com.example.myapplication.DemoProject.TaskTable

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.DemoProject.ContactDAO

@Database(entities = [Contact:: class],version = 1)
abstract  class ContactDatabase : RoomDatabase() {
    abstract fun contactDao() : ContactDAO

}