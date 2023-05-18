package com.example.myapplication.BroadcastReceiver

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.myapplication.R

class BroadcastReceiverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_reciever)

        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(battery,filter)
    }
    private val  battery  = object : BroadcastReceiver(){
        @SuppressLint("MissingPermission")
        override fun onReceive(context: Context, intent:Intent?) {
            var batteryLevel = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL,-1)
            val builder = NotificationCompat.Builder(context, "battery_channel_id")
                .setContentTitle("Notification")
                .setContentText("Battery Level : $batteryLevel%")
                .setSmallIcon(R.drawable.ic_home)
            val notificationManager = NotificationManagerCompat.from(context)
            notificationManager.notify(1,builder.build())
            val textView : TextView = findViewById(R.id.textviewforbattery)
            textView.text = batteryLevel.toString()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(battery)
    }
}
