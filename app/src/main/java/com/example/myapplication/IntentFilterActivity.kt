package com.example.myapplication
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


class IntentFilterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_filter)
        val imageview = findViewById<ImageView>(R.id.imageview)
        if (intent.hasExtra("android.intent.extra.STREAM")){
            val bundle = intent.extras
            val strUri = bundle?.get("android.intent.extra.STREAM")
            val uri = Uri.parse(strUri.toString())
            imageview.setImageURI(uri)
        }
        var btn = findViewById<Button>(R.id.btnenter)
        btn.setOnClickListener {
            val sendIntent = Intent(Intent.ACTION_VIEW)
            sendIntent.data = Uri.parse("https://www.google.com")
            val chooser: Intent = Intent.createChooser(sendIntent, "next screen")
            startActivity(chooser)
        }
    }
}




