package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class FloatingButton : AppCompatActivity() {

//    lateinit var   floatbtn : FloatingActionButton
//    lateinit var extfloatbnt : ExtendedFloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floatingbutton)

//        floatbtn = findViewById(R.id.floating_btn)
//        extfloatbnt = findViewById(R.id.ex_floating_btn)

        findViewById<FloatingActionButton>(R.id.floating_btn).setOnClickListener{
            Snackbar.make(it, "Simple Snackbar", Snackbar.LENGTH_LONG).show()
        }


        findViewById<ExtendedFloatingActionButton>(R.id.ex_floating_btn).setOnClickListener{

            Snackbar.make(it, "Another Snackbar", Snackbar.LENGTH_LONG).setAction("view"){
                Snackbar.make(it, "Welcomes", Snackbar.LENGTH_LONG).setBackgroundTint(Color.RED).show()
            }.setActionTextColor(Color.GREEN).show()

        }

    }
}