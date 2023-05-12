package com.example.myapplication
import DialogActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Layout.SetLayout
import com.example.myapplication.RecycleView.RecyclerView

class ActivityAllproject : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allproject)

        findViewById<Button>(R.id.btn1).setOnClickListener {
            val myIntent = Intent(this, ActivityLayout::class.java)
            startActivity(myIntent)
        }

        findViewById<Button>(R.id.btn2).setOnClickListener {
            val myIntent = Intent(this, ActivityView::class.java)
            startActivity(myIntent)
        }

        findViewById<Button>(R.id.btn3).setOnClickListener {
            //    val myIntent = Intent(this, ::class.java)
            //    startActivity(myIntent)
        }

        findViewById<Button>(R.id.btn4).setOnClickListener {
            val myIntent = Intent(this, CustomButton::class.java)
            startActivity(myIntent)
        }

        findViewById<Button>(R.id.btn5).setOnClickListener {
            val myIntent = Intent(this, Shapesdrawable::class.java)
            startActivity(myIntent)
        }

        findViewById<Button>(R.id.btn6).setOnClickListener {
            val myIntent = Intent(this, Tab_layout::class.java)
            startActivity(myIntent)
        }

        findViewById<Button>(R.id.btn7).setOnClickListener {
            val myIntent = Intent(this, RecyclerView::class.java)
            startActivity(myIntent)
        }

        findViewById<Button>(R.id.btn8).setOnClickListener {
            val myIntent = Intent(this, Floatingbutton::class.java)
            startActivity(myIntent)
        }

        findViewById<Button>(R.id.btn9).setOnClickListener {
            startActivity(Intent(this,ActivityRuntimePermission::class.java))
        }

        findViewById<Button>(R.id.btn10).setOnClickListener {
            val myIntent = Intent(this, ActivityFragment::class.java)
            startActivity(myIntent)
        }
        findViewById<Button>(R.id.btn11).setOnClickListener {
            val myIntent = Intent(this, DialogActivity::class.java)
            startActivity(myIntent)
        }
        findViewById<Button>(R.id.btn12).setOnClickListener {
            startActivity(Intent(this, ActivityNotification::class.java))
        }
        findViewById<Button>(R.id.btn13).setOnClickListener {
            startActivity(Intent(this, SetLayout::class.java))
        }
        findViewById<Button>(R.id.btn14).setOnClickListener {
            startActivity(Intent(this, IntentFilterActivity::class.java))
        }
    }
}