package com.example.myapplication.DemoProject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.myapplication.R
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainRoomDatabaseActivity : AppCompatActivity() {
    lateinit var database : ContactDatabase
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_room_database)

        database = ContactDatabase.getDatabase(this)
        database.contactDao().insertContact(Contact(0,"title","des"))
    }
}