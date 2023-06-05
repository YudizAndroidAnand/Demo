package com.example.myapplication
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.myapplication.json.retrofit.GetDataActivity
import com.example.myapplication.recycleView.RecyclerView
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class PushNotification : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        Log.d(TAG, "my token: $token")
        super.onNewToken(token)
    }
    override fun onMessageReceived(message: RemoteMessage) {

        Log.d(TAG, "my message: $message")
        if(message.notification != null){
            val setActivity = checkValue(message)
            getNotification(message.notification?.title, message.notification?.body, setActivity)
            Log.d(TAG, "Refreshed message ")
            super.onMessageReceived(message)
        }
    }
    @SuppressLint("ObsoleteSdkInt")
    private fun getNotification(title: String?,
                                body: String?,
                                pendingIntent: PendingIntent?) {
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
            .setContentTitle(title)
            .setContentText(body)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
        notificationManager.notify(12, builder.build())
    }
    private fun checkValue(s: RemoteMessage): PendingIntent? {
        when (s.data["onclick"]) {
            "RecyclerView" -> {
                val intent = Intent(applicationContext, RecyclerView::class.java)
                intent.addCategory(Intent.CATEGORY_LAUNCHER)
                intent.action = Intent.ACTION_MAIN
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                return PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
            }
            "GetData" -> {
                val intent = Intent(applicationContext, GetDataActivity::class.java)
                intent.addCategory(Intent.CATEGORY_LAUNCHER)
                intent.action = Intent.ACTION_MAIN
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                intent.putExtra("push","product")
                return PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
            }
            "SaveFileActivity" -> {
                val intent = Intent(applicationContext, SaveFileActivity::class.java)
                intent.addCategory(Intent.CATEGORY_LAUNCHER)
                intent.action = Intent.ACTION_MAIN
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                return PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
            }
        }
        return null
    }
}
