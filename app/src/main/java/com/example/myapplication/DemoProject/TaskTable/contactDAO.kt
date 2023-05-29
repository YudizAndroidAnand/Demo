package com.example.myapplication.DemoProject

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.DemoProject.TaskTable.Contact

@Dao
interface ContactDAO {

    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)


    @Delete
    suspend fun deleteContact(contact: Contact)


    @Query("SELECT * FROM contact")
     fun getContact() : List<Contact>
}