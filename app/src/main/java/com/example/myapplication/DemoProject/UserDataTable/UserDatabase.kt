package com.example.myapplication.DemoProject.UserDataTable

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.DemoProject.ContactDAO
import com.example.myapplication.DemoProject.TaskTable.Contact

@Database(entities = [Contact:: class],version = 1)
abstract  class UserDatabase : RoomDatabase() {
    abstract fun userDao() : UserDAO

}