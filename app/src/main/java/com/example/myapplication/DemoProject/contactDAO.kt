package com.example.myapplication.DemoProject

import androidx.room.*

@Dao
interface ContactDAO {

    @Insert
    fun insertContact(contact:Contact)

    @Update
    fun updateContact(contact:Contact)

    @Delete
    fun deleteContact(contact:Contact)

    @Query("SELECT * FROM contact")
    fun getContact() : List<Contact>
}