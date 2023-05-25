package com.example.myapplication.MainScreen
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.*
import com.example.myapplication.CustomButton.CustomButton
import com.example.myapplication.Dialog.DialogDateTime
import com.example.myapplication.Fragment.ActivityFragment
import com.example.myapplication.Layout.ActivityView
import com.example.myapplication.Layout.MainActivity
import com.example.myapplication.Layout.SetLayout
import com.example.myapplication.Notification.ActivityNotification
import com.example.myapplication.RecycleView.RecyclerView

class ActivityAllProject : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allproject)

        findViewById<Button>(R.id.btn1).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        findViewById<Button>(R.id.btn2).setOnClickListener {
            startActivity(Intent(this, ActivityView::class.java))
        }
        findViewById<Button>(R.id.btn4).setOnClickListener {
            startActivity(Intent(this, CustomButton::class.java))
        }
        findViewById<Button>(R.id.btn5).setOnClickListener {
            startActivity(Intent(this, ShapesDrawable::class.java))
        }
        findViewById<Button>(R.id.btn6).setOnClickListener {
            startActivity(Intent(this, Tab_layout::class.java))
        }
        findViewById<Button>(R.id.btn7).setOnClickListener {
            startActivity(Intent(this, RecyclerView::class.java))
        }
        findViewById<Button>(R.id.btn8).setOnClickListener {
            startActivity(Intent(this, FloatingButtonActivity::class.java))
        }
        findViewById<Button>(R.id.btn9).setOnClickListener {
            startActivity(Intent(this, ActivityRuntimePermission::class.java))
        }
        findViewById<Button>(R.id.btn10).setOnClickListener {
            startActivity(Intent(this, ActivityFragment::class.java))
        }
        findViewById<Button>(R.id.btn11).setOnClickListener {
            startActivity(Intent(this, DialogDateTime::class.java))
        }
        findViewById<Button>(R.id.btn12).setOnClickListener {
            startActivity(Intent(this, ActivityNotification::class.java))
        }
        findViewById<Button>(R.id.btn13).setOnClickListener {
            startActivity(Intent(this, SetLayout::class.java))
        }
        findViewById<Button>(R.id.btnNextScreen).setOnClickListener {
            startActivity(Intent(this, ActivityAllProject2::class.java))
        }

    }
}