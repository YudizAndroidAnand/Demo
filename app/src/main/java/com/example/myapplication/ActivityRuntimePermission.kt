package com.example.myapplication
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class ActivityRuntimePermission : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var selectButton: Button
    companion object {
        private const val READ_MEDIA_IMAGES_PERMISSION_CODE = 1
        private const val GALLERY_REQUEST_CODE = 2
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runtime_permission)
        imageView = findViewById(R.id.imageViewGallery)
        selectButton = findViewById(R.id.buttonPicture)
        selectButton.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_MEDIA_IMAGES) == PackageManager.PERMISSION_GRANTED) {
                gallery()
            } else {
                requestExternalStoragePermission()
            }
        }
    }
    private fun requestExternalStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.READ_MEDIA_IMAGES)) {
            showPermissionDeniedDialog()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_MEDIA_IMAGES),READ_MEDIA_IMAGES_PERMISSION_CODE)
        }
    }
    private fun showPermissionDeniedDialog() {
        AlertDialog.Builder(this)
            .setTitle("Permission Required")
            .setMessage(" Aims needs permission to access media files.")
            .setPositiveButton("Grant Permission") { _, _ ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri: Uri = Uri.fromParts("package", packageName, null)
                intent.data = uri
                startActivity(intent)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun gallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK) {
            data?.data?.let { uri ->
                imageView.setImageURI(uri)
            }
        }
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == READ_MEDIA_IMAGES_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                gallery()
            } else {
                Toast.makeText(
                    this,
                    "Permission denied.grant permission.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
