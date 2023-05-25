package com.example.myapplication.DemoProject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact:: class],version = 1)
abstract  class ContactDatabase : RoomDatabase() {
    abstract fun contactDao() : ContactDAO

    companion object{
        @Volatile
        private var INSTANCE : ContactDatabase? = null
        fun getDatabase(context: Context) : ContactDatabase{
            if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "contact.db").build()
            }
            return INSTANCE!!
        }
    }
}