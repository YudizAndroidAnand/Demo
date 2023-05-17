package com.example.myapplication
import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.webkit.WebChromeClient.FileChooserParams
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class MyWorkManager(appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {
    override fun doWork(): Result {

          return  Result.failure()
    }
}