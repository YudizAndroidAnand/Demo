package com.example.myapplication.DemoProject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R

class SignupActivity : AppCompatActivity() {

    lateinit var database : ContactDatabase
    lateinit var fullname : EditText
    lateinit var mail : EditText
    lateinit var mobilenumber : EditText
    lateinit var password : EditText
    lateinit var confirmpassword : EditText
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\'.+[a-z]+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        fullname = findViewById(R.id.edittext_name)
        mail = findViewById(R.id.edittext_email)
        mobilenumber = findViewById(R.id.edittext_mobile_number)
        password = findViewById(R.id.edittext_password)
        confirmpassword = findViewById(R.id.edittext_confirm_password)
        findViewById<TextView>(R.id.textview_back_to_login).setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }

        findViewById<Button>(R.id.button_Signup).setOnClickListener {
            validation()
        }
    }
    fun validation(){
        if (fullname.text.isEmpty()){
            fullname.error = "Enter you name"
        }
        else if (fullname.text.toString().length < 3){
            fullname.error = "Enter valid name"
        }
        else if (mail.text.isEmpty()){
            mail.error = "Enter your Email"
        }
        else if (mail.text.toString().matches(emailPattern.toRegex())){
            fullname.error = "Enter valid Email"
        }
        else if (mobilenumber.text.isEmpty()){
            mobilenumber.error = "Enter your Mobile Number"
        }
        else if (mobilenumber.text.toString().length != 10){
            mobilenumber.error = "Enter valid Mobile Number"
        }
        else if (password.text.isEmpty()){
            password.error = "Enter your Password"
        }
        else if (confirmpassword.text.isEmpty()){
            confirmpassword.error = "Enter your Password"
        }
        else if (password.text.toString().length < 8){
            password.error = "Enter valid Password"
        }
        else if (confirmpassword.text.toString() != password.text.toString()){
            confirmpassword.error = "Enter valid Password"
        }
        else{
            database = ContactDatabase.getDatabase(this)
            database.contactDao().insertContact(Contact(0,fullname.text.toString(),mail.text.toString(),mobilenumber.text.toString(),password.text.toString()))
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}