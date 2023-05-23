package com.example.myapplication.BroadcastReceiver
import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R



class BroadcastReceiverCustomActivity : AppCompatActivity() {

    val showBattery : TextView = findViewById(R.id.textviewBattery)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast2)
    }
    private val battery = MyBroadcastReceiver()


    public override fun onResume() {
        super.onResume()
        registerReceiver(battery, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }
    public override fun onPause() {
        super.onPause()
        unregisterReceiver(battery)
    }
}