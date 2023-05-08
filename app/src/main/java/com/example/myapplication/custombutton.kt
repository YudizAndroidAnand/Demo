package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
 class custombutton : AppCompatActivity() {
    private lateinit var customButton: BtnProgressbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custombutton)
         customButton = findViewById(R.id.customvieww)

        setButton()
        if (customButton != null) {
            customButton.setOnClickListener {
                customButton.setBackgroundResource(R.drawable.btnempty)
                customButton.showingloader()
                Handler().postDelayed({
                    customButton.hideloader()
                    customButton.setBackgroundResource(R.drawable.enablebtn)
                }, 10000)
            }
        }
    }
    private fun setButton() {
        customButton.isEnabled()
        customButton.setBackgroundResource(R.drawable.btnempty)
        customButton.hideloader()
    }
}


