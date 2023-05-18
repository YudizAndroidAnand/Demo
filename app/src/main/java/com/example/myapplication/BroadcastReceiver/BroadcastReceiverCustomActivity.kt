package com.example.myapplication.BroadcastReceiver

import android.annotation.SuppressLint
import android.app.Notification.EXTRA_COMPACT_ACTIONS
import android.app.Notification.EXTRA_NOTIFICATION_ID
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.RemoteViews
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.myapplication.R

class BroadcastReceiverCustomActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast2)
    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(battery)
    }
    override fun onStart() {
        super.onStart()
        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(battery,filter)
    }
    val battery = object : BroadcastReceiver(){
        @SuppressLint("MissingPermission")
        override fun onReceive(context : Context, intent: Intent) {
            val batteryLevel1 = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
            val notificationLayout = RemoteViews("com.example.myapplication", R.layout.broadcastcustomnotification)
            val builder = NotificationCompat.Builder(context, "channel2")
                .setContentTitle("Battery Level : $batteryLevel1%")
                .setSmallIcon(R.drawable.ic_battery)
                .setStyle(NotificationCompat.DecoratedCustomViewStyle())
                .setCustomBigContentView(notificationLayout)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            val notificationManager = NotificationManagerCompat.from(context)
            notificationManager.notify(12, builder.build())
            val textview:TextView = findViewById(R.id.textview)
            textview.text = batteryLevel1.toString()
        }
    }
}