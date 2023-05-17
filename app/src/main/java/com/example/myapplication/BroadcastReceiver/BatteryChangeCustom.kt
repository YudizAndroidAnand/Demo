package com.example.myapplication.BroadcastReceiver

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.view.LayoutInflater
import android.widget.RemoteViews
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.myapplication.R

class BatteryChangeCustom : BroadcastReceiver() {


    @SuppressLint("MissingPermission", "MissingInflatedId")
    override fun onReceive(context: Context, intent: Intent) {
        val batteryLevel1 = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val notificationLayout = RemoteViews("com.example.myapplication", R.layout.broadcastcustomnotification)
        val builder = NotificationCompat.Builder(context, "channel2")
            .setContentTitle("Battery Level : $batteryLevel1%")
            .setSmallIcon(R.drawable.ic_battery)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setCustomBigContentView(notificationLayout)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(12, builder.build())
        val view = LayoutInflater.from(context).inflate(R.layout.activity_broadcast2, null, false)
        val textview : TextView = view.findViewById(R.id.textview)
        textview.text = batteryLevel1.toString()
    }
}