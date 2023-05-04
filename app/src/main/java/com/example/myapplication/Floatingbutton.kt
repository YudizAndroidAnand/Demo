package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class Floatingbutton : AppCompatActivity() {

    lateinit var   floatbtn : FloatingActionButton
    lateinit var extfloatbnt : ExtendedFloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floatingbutton)

        floatbtn = findViewById(R.id.floatingbtn)
        extfloatbnt = findViewById(R.id.exfloatingbtn)

        floatbtn.setOnClickListener{
            Snackbar.make(it, "Simple Snackbar", Snackbar.LENGTH_LONG).show()
        }


        extfloatbnt.setOnClickListener{

            Snackbar.make(it, "Another Snackbar", Snackbar.LENGTH_LONG).setAction("view") {
                Snackbar.make(it, "Welcomes", Snackbar.LENGTH_LONG).show()
            }.show()

        }

    }
}