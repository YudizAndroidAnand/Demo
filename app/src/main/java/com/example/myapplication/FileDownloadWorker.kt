package com.example.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.core.app.NotificationCompat
import androidx.core.net.toUri
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import java.io.File
import java.io.FileOutputStream
import java.net.URL
class FileDownloadWorker{

}
/*class FileDownloadWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    val filename = inputData.getString("KEY_FILE_NAME")
    val url = inputData.getString("KEY_FILE_URL")
    val mimeType = when(inputData.getString("KEY_FILE_TYPE")){
        "PDF" -> "application/pdf"
        "PNG" -> "image/png"
        "MP4" -> "video/mp4"
        else -> ""
    }
    override fun doWork(): Result {

        url?.let {
            return try {
                val uri = downloadFileFromUri(url,mimeType,filename )
                uri?.let {

                }
                Result.success(workDataOf("KEY_FILE_URI" to uri.toString()))
            } catch (e: Exception) {
                e.printStackTrace()
                Result.failure()
            }

        }
        return Result.failure()
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
}*/