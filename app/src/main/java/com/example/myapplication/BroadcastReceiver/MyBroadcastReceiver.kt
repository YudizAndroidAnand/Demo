package com.example.myapplication.BroadcastReceiver

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.util.Log
import android.widget.RemoteViews
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class MyBroadcastReceiver: BroadcastReceiver() {
    val obj = BroadcastReceiverCustomActivity()
    @SuppressLint("MissingPermission")
    override fun onReceive(context: Context, intent: Intent) {
        if(intent != null){
            Log.d("Broadcast","${intent.action}")
        }
        val batteryLevel1 = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
        obj.showBattery.text = batteryLevel1.toString()
        val notificationLayout = RemoteViews("com.example.myapplication", R.layout.broadcastcustomnotification)
        notificationLayout.setOnClickPendingIntent(R.id.btnStart,PendingIntent.getBroadcast(context,0, Intent(context, MainActivity::class.java).setAction("Start"), PendingIntent.FLAG_MUTABLE))
        PendingIntent.getBroadcast(context,0, Intent(context, MainActivity::class.java).setAction("Start"), PendingIntent.FLAG_IMMUTABLE)

        notificationLayout.setOnClickPendingIntent(R.id.btnStop, PendingIntent.getBroadcast(context,0, Intent(context, MainActivity::class.java).setAction("Stop"), PendingIntent.FLAG_MUTABLE))
        PendingIntent.getBroadcast(context,0, Intent(context, MainActivity::class.java).setAction("Stop"), PendingIntent.FLAG_IMMUTABLE)

        val batteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
        val builder = NotificationCompat.Builder(context, "channel2")
            .setContentTitle("Battery Level : $batteryLevel%")
            .setSmallIcon(R.drawable.ic_battery)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setCustomBigContentView(notificationLayout)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(12, builder.build())

        when(intent.action){
            "Start" -> {
                Toast.makeText(context, "start", Toast.LENGTH_SHORT).show()
                obj.onResume()

            }
            "Stop" ->{
                Toast.makeText(context, "Stop", Toast.LENGTH_SHORT).show()
                obj.onPause()
            }
        }
    }
}