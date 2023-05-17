package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Surface
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest

class WorkManagerActivity : AppCompatActivity() {
    private lateinit var requestMultiplePermission: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)

        val uploadWorkRequest: WorkRequest = OneTimeWorkRequestBuilder<MyWorkManager>().build()

        WorkManager.getInstance(this).enqueue(uploadWorkRequest)


    }
}
