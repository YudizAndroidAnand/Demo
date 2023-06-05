package com.example.myapplication.layout
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.myapplication.R

class ActivityView : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        val text = findViewById<EditText>(R.id.edittext)
        val languages = resources.getStringArray(R.array.Languages)

        val spinner = findViewById<Spinner>(R.id.spinner)
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
            spinner.adapter = adapter

        findViewById<Button>(R.id.buttonSubmit).setOnClickListener {
            //implement code
        }
        val toggle: ToggleButton = findViewById(R.id.btnToggle)
        toggle.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, if(isChecked) "Geek Mode ON" else "Geek Mode OFF", Toast.LENGTH_SHORT).show()
        }


    }
}