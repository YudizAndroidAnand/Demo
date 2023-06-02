package com.example.myapplication
import android.annotation.SuppressLint
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
        super.onNewToken(token)
        Log.d(TAG, "my token: $token")
    }
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.d(TAG, "my message: $message")
        if(message.notification != null){
            message.notification?.body?.let { getNotification(it) }
            Log.d(TAG, "Refreshed message ")
        }
    }
    @SuppressLint("ObsoleteSdkInt")
    private fun getNotification(message: String) {
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
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(message)
            .setContentText("text")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
        notificationManager.notify(12, builder.build())
    }
}
