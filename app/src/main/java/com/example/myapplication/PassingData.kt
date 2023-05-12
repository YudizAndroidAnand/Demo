package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.Fragment.CommunicteTwoFragment
import com.example.myapplication.Fragment.FragmentForHome

class PassingData : AppCompatActivity(), CommunicteTwoFragment {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passing_data)
        val homefragment = FragmentForHome()
        //supportFragmentManager.beginTransaction().replace(R.id., ).commit()
    }

    override fun sendText(msg: String) {
        val textview = findViewById<TextView>(R.id.textview)
        val bundle = Bundle()
        bundle.putString("inputText",msg)
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.commit()

        //text.text = getText(text)
        /*fun onBackPressed() {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStack()
            } else {
                finish()
            }
        }*/
    }
}