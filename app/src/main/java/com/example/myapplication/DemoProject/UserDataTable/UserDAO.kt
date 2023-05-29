package com.example.myapplication.DemoProject.UserDataTable

import androidx.room.*
import com.example.myapplication.DemoProject.TaskTable.Contact

@Dao
interface UserDAO {

    @Insert
    suspend fun insertUserData(userData: UserSignupData)

    @Update
    suspend fun updateUserData(userData: UserSignupData)


    @Delete
    suspend fun deleteUserData(userData: UserSignupData)


    @Query("SELECT * FROM UserData")
    suspend fun getUserData() : List<UserSignupData>

//    @Query("SELECT * FORM contact WHERE email = :email")
//    suspend fun getEmail(email:String) : List<UserSignupData>

}