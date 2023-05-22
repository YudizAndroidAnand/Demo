package com.example.myapplication.BroadcastReceiver

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RemoteViews
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
            val batteryLevel1 = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
            val builder = NotificationCompat.Builder(context, "channel2")
                .setContentTitle("Battery Level : $batteryLevel1%")
                .setSmallIcon(R.drawable.ic_battery)
                .setStyle(NotificationCompat.DecoratedCustomViewStyle())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            val notificationManager = NotificationManagerCompat.from(context)
            notificationManager.notify(12, builder.build())
            val textview:TextView = findViewById(R.id.textviewForBattery)
            textview.text = batteryLevel1.toString()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(battery)
    }
}
