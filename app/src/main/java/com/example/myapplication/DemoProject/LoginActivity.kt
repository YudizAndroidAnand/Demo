package com.example.myapplication.DemoProject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.DemoProject.TaskTable.ContactDatabase
import com.example.myapplication.DemoProject.UserDataTable.UserDatabase
import com.example.myapplication.DemoProject.UserDataTable.UserSignupData
import com.example.myapplication.R
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var database: UserDatabase

    lateinit var useremail: EditText
    lateinit var userpassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_screen)

        useremail = findViewById(R.id.edittext_email)
        userpassword = findViewById(R.id.edittext_password)

        findViewById<Button>(R.id.button_login).setOnClickListener {
//            validation()
            startActivity(Intent(this@LoginActivity, HomeScreenActivity::class.java))
        }
        findViewById<TextView>(R.id.textview_signup).setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }

//    private fun validation() {
//        if (useremail.text.isEmpty()) {
//            Toast.makeText(this, "Enter your Email", Toast.LENGTH_SHORT).show()
//        } else if (userpassword.text.isEmpty()) {
//            Toast.makeText(this, "Enter your Password", Toast.LENGTH_SHORT).show()
//        } else {
//            GlobalScope.launch {
//                val list = database.userDao().getEmail(useremail.text.toString())
//                if (useremail.text.toString() in list) {
//                    startActivity(Intent(this@LoginActivity, HomeScreenActivity::class.java))
//                }
//              else{
//                    Toast.makeText(this@LoginActivity, "Invalid user id and password", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }
}