package com.example.myapplication.DemoProject.UserDataTable

import androidx.room.*

@Dao
interface UserDAO {

    @Insert
    suspend fun insertContact(userData: UserSignupData)

    @Update
    suspend fun updateContact(userData: UserSignupData)


    @Delete
    suspend fun deleteContact(userData: UserSignupData)


    @Query("SELECT * FROM contact")
    fun getContact() : List<UserSignupData>
}