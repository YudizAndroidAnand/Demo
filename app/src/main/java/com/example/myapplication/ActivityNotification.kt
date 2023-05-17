package com.example.myapplication
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Build.VERSION_CODES
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.example.myapplication.RecycleView.RecyclerView

class ActivityNotification : AppCompatActivity() {

    private lateinit var notificationManager: NotificationManager
    val id : Int = 12

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val fullscreenbtn: Button = findViewById(R.id.fullscreenotification)
        val customnotification: Button = findViewById(R.id.customnotification)
        val normalnotification: Button = findViewById(R.id.normalnotification)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        createNotificationChannel()
        createNotificationChannel1()
        createNotificationChannel2()

        normalnotification.setOnClickListener {
            createnormalnotification()
        }

        fullscreenbtn.setOnClickListener {
            createfullscreennotification()
        }
        customnotification.setOnClickListener {
            createCustomNotification()
        }
    }

    @SuppressLint("RemoteViewLayout")
    private fun createnormalnotification() {
        val builder = NotificationCompat.Builder(this, "channel")
            .setSmallIcon(R.drawable.ic_home)
            .setContentTitle("AD-SBINB")
            .setContentText( "A/c *1234 Debited for Rs.1000 on 11-05-2023 " +
                    "Avl Bal Rs:9000 - State Bank Of India")
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Much longer text that cannot fit one line.Much longer text that cannot fit one line.Much longer text that cannot fit one line."))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        notificationManager.notify(id, builder.build())
    }

    private fun createfullscreennotification() {
        val intent = Intent(this, RecyclerView::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(this, "channel1")
            .setSmallIcon(R.drawable.ic_home)
            .setContentTitle("My notification")
            .setContentText("Hello World!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        notificationManager.notify(id, builder.build())
    }

    private fun createCustomNotification() {
        val notificationLayout = RemoteViews(packageName, R.layout.activity_custom_notification_view)
        val builder = NotificationCompat.Builder(this, "channel2")
            .setContentTitle("Hotstar")
            .setSmallIcon(R.drawable.ic_home)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setCustomBigContentView(notificationLayout)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        notificationManager.notify(id, builder.build())
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= VERSION_CODES.O) {
            val name = "Notification Channel"
            val descriptionText = "Notification Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channel".toString(), name, importance).apply {
                description = descriptionText
            }
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun createNotificationChannel1() {
        if (Build.VERSION.SDK_INT >= VERSION_CODES.O) {
            val name = "Notification Channel2"
            val descriptionText = "Notification Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channel1", name, importance).apply {
                description = descriptionText
            }
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun createNotificationChannel2() {
        if (Build.VERSION.SDK_INT >= VERSION_CODES.O) {
            val name = "Notification Channel3"
            val descriptionText = "Notification Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channel2", name, importance).apply {
                description = descriptionText
            }
            notificationManager.createNotificationChannel(channel)
        }
    }
}



