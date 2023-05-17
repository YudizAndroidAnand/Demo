package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.BroadcastReceiver.BroadcastRecieverActivity
import com.example.myapplication.Layout.SetLayout
import com.example.myapplication.RecycleView.RecyclerView

class ActivityAllproject : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allproject)

        findViewById<Button>(R.id.btn1).setOnClickListener {
            startActivity(Intent(this, ActivityLayout::class.java))
        }
        findViewById<Button>(R.id.btn2).setOnClickListener {
            startActivity(Intent(this, ActivityView::class.java))
        }
        findViewById<Button>(R.id.btn4).setOnClickListener {
            startActivity(Intent(this, CustomButton::class.java))
        }
        findViewById<Button>(R.id.btn5).setOnClickListener {
            startActivity(Intent(this, Shapesdrawable::class.java))
        }
        findViewById<Button>(R.id.btn6).setOnClickListener {
            startActivity(Intent(this, Tab_layout::class.java))
        }
        findViewById<Button>(R.id.btn7).setOnClickListener {
            startActivity(Intent(this, RecyclerView::class.java))
        }
        findViewById<Button>(R.id.btn8).setOnClickListener {
            startActivity(Intent(this, Floatingbutton::class.java))
        }
        findViewById<Button>(R.id.btn9).setOnClickListener {
            startActivity(Intent(this,ActivityRuntimePermission::class.java))
        }
        findViewById<Button>(R.id.btn10).setOnClickListener {
            startActivity(Intent(this, ActivityFragment::class.java))
        }
        findViewById<Button>(R.id.btn11).setOnClickListener {
            startActivity(Intent(this, DialogBoxActivity::class.java))
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
        findViewById<Button>(R.id.btn15).setOnClickListener {
            startActivity(Intent(this, BroadcastRecieverActivity::class.java))
        }
        findViewById<Button>(R.id.btn15).setOnClickListener {
            startActivity(Intent(this, WorkManagerActivity::class.java))
        }
    }
}