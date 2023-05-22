package com.example.myapplication

import BroadCastReceiverClass
import FileDownloadWorker
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.PendingIntent
import android.content.*
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Surface
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.work.*
import com.example.myapplication.databinding.ActivityFileDownloadWorkerBinding

class WorkManagerActivity : AppCompatActivity() {

    private lateinit var statusTv : TextView
    lateinit var liveBatteryData : TextView
    private var data = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)

       // statusTv = findViewById(R.id.status_tv)
       // liveBatteryData = findViewById(R.id.liveStatusOfBattery_tv)
        statusTv.text = ""
        actionOnBroadCast()
        register(0)

        // registerReceiver(BroadCastReceiverClass(),Intent.ACTION_BATTERY_CHANGED)
    }

    fun register(percentageData : Int){

        registerReceiver(BroadCastReceiverClass(), IntentFilter(Intent.ACTION_BATTERY_CHANGED))

        liveBatteryData.text = "Your battery percentage is "+percentageData.toString()+"%"
    }
    fun unregister(){

        onStart()
        unregisterReceiver(BroadCastReceiverClass())
    }

    @SuppressLint("NewApi")
    private fun actionOnBroadCast() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel("BatteryAction","BatteryChannel",NotificationManager.IMPORTANCE_HIGH)
            channel.description = "This Is Battery BroadCast"

            val intent = Intent(this,FileDownloadWorker::class.java)
            // val pendingIntent = PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_IMMUTABLE)
            //   val intent = Intent(this,ActionOnBroadCastActivity::class.java)
            // val pendingIntent = PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_IMMUTABLE)

            val layoutRemote = RemoteViews(packageName,R.layout.custom_expanded_notifiction)
            layoutRemote.setOnClickPendingIntent(R.id.broadCast_start,
                PendingIntent.getBroadcast(this,0, Intent(this,BroadCastReceiverClass::class.java).setAction("Start"), PendingIntent.FLAG_MUTABLE))
            PendingIntent.getBroadcast(this,0, Intent(this,BroadCastReceiverClass::class.java).setAction("Start"),PendingIntent.FLAG_IMMUTABLE))
            layoutRemote.setOnClickPendingIntent(R.id.broadCast_stop,
                PendingIntent.getBroadcast(this,0, Intent(this,BroadCastReceiverClass::class.java).setAction("Stop"),PendingIntent.FLAG_MUTABLE))
            PendingIntent.getBroadcast(this,0, Intent(this,BroadCastReceiverClass::class.java).setAction("Stop"),PendingIntent.FLAG_IMMUTABLE))

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
            val builder = NotificationCompat.Builder(this,"BatteryAction")
            builder.apply {
                setSmallIcon(R.drawable.ic_battery)
                setContentTitle("Activity Second")
                setPriority(NotificationCompat.PRIORITY_HIGH)
                //  setContentIntent(pendingIntent)
                priority = NotificationCompat.PRIORITY_HIGH
                //  setContentIntent(pendingIntent)
                setAutoCancel(true)
                layoutRemote.setTextViewText(R.id.statusCheck_tv,"12"+" "+data)
                setCustomBigContentView(layoutRemote)
            }
            manager.notify(0,builder.build())
        }
    }

    private val batteryBroadCast = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent != null) {
                Log.d("BroadCast ","${intent.action}")
            }
            val percentageData = intent?.getIntExtra("level",0)
            liveBatteryData.text = percentageData.toString()
            data = liveBatteryData.text.toString()
            actionOnBroadCast()
        }
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(batteryBroadCast, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }
    override fun onStop() {
        super.onStop()
        unregisterReceiver(batteryBroadCast)
    }
}
}
