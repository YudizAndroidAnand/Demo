package com.example.myapplication
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ContentValues.TAG
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class PushNotification : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        getNotification()
    }

    private fun getNotification() {
        val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification Channel"
            val descriptionText = "Notification Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channel", name, importance).apply {
                description = descriptionText
            }
            notificationManager.createNotificationChannel(channel)
        }
        val builder = NotificationCompat.Builder(this, "channel")
            .setSmallIcon(R.drawable.ic_home)
            .setContentTitle("title")
            .setContentText("text")
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Much longer text that cannot fit one line.Much longer text that cannot fit one line.Much longer text that cannot fit one line.")
            )
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        notificationManager.notify(12, builder.build())
    }
}