package com.example.myapplication.workManager
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.core.app.NotificationCompat
import androidx.core.net.toUri
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.myapplication.R
import java.io.File
import java.io.FileOutputStream
import java.net.URL


class FileDownloadWorker(private val context: Context, private val workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    private val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    override fun doWork(): Result {
        displayNotification()

        val mimeType = when(workerParameters.inputData.getString("KEY_FILE_TYPE")){
            "PDF" -> "application/pdf"
            "PNG" -> "image/png"
            "MP4" -> "video/mp4"
            else -> ""
        }
        val filename = workerParameters.inputData.getString("KEY_FILE_NAME")
        val url = workerParameters.inputData.getString("KEY_FILE_URL")
        url?.let {
            return try {
                val uri = downloadFileFromUri(url,mimeType,filename )
                uri?.let {
                }
                notificationManager.cancel(10)
                Result.success(workDataOf("KEY_FILE_URI" to uri.toString()))
            } catch (e: Exception) {
                e.printStackTrace()
                Result.failure()
            }
        }
        return Result.failure()
    }
    @SuppressLint("NewApi")
    private fun displayNotification() {
        val channel = NotificationChannel("CHANNEL_NAME", "CHANNEL_NAME", NotificationManager.IMPORTANCE_DEFAULT)
        channel.enableVibration(false)
        notificationManager.createNotificationChannel(channel)
        val notificationBuilder =
            NotificationCompat.Builder(applicationContext, "CHANNEL_NAME")

        notificationBuilder
            .setContentTitle("CHANNEL_DESC")
            .setSmallIcon(R.drawable.ic_launcher_background)

        notificationManager.notify(10, notificationBuilder.build())
    }
    private fun downloadFileFromUri(url: String,mimeType: String, filename: String?): Uri? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

            val contentValues = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
                put(MediaStore.MediaColumns.MIME_TYPE, mimeType)
                put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
            }
            val resolver = context.contentResolver
            val uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues)
            return if (uri != null) {
                URL(url).openStream().use { input ->
                    resolver.openOutputStream(uri).use { output ->
                        input.copyTo(output!!, DEFAULT_BUFFER_SIZE)
                    }
                }
                uri
            } else {
                null
            }
        } else {
            val target = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                filename
            )
            URL(url).openStream().use { input ->
                FileOutputStream(target).use { output ->
                    input.copyTo(output)
                }
            }
            return target.toUri()
        }
    }
}