package com.example.myapplication.DemoProject

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeScreenActivity : AppCompatActivity() {


    private lateinit var newrecyclerView: RecyclerView
    private lateinit var list: MutableList<UserDataRecycle>
    lateinit var dialogMain : Dialog
    lateinit var titleName : EditText
    lateinit var descriptionName : EditText
    lateinit var cancelButton : Button
    lateinit var addButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        findViewById<Button>(R.id.button_logout).setOnClickListener {
            logoutDialogBox()
        }
        findViewById<FloatingActionButton>(R.id.floating_button_add_task).setOnClickListener{
            addTaskDialogBox()
        }

        newrecyclerView = findViewById(R.id.recyclerview)

        list = mutableListOf(UserDataRecycle("a","a"),
            UserDataRecycle("a","a"),)
        val myadapter = AdapterRecycle(this,list)
        newrecyclerView.adapter = myadapter
    }

    private fun logoutDialogBox() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Are you sure")
        builder.setMessage("Log out")
        builder.setPositiveButton("Logout") { dialog,_ ->
            dialog.dismiss()
            startActivity(Intent(this,LoginActivity::class.java))
        }
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }

    private fun addTaskDialogBox() {
        dialogMain = Dialog(this)
            dialogMain.setContentView(R.layout.add_task_dailog)
            titleName = dialogMain.findViewById(R.id.edittext_title)
            descriptionName = dialogMain.findViewById(R.id.edittext_description)
            cancelButton = dialogMain.findViewById(R.id.button_cancel)
            addButton = dialogMain.findViewById(R.id.button_add)
            dialogMain.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialogMain.show()
        cancelButton.setOnClickListener {
            dialogMain.dismiss()
        }
        addButton.setOnClickListener {
            if (titleName.text.isEmpty() || descriptionName.text.isEmpty()){
                if (titleName.text.isEmpty()){
                    Toast.makeText(this, "Enter the title", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "Enter the description", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                dialogMain.dismiss()
            }
        }
    }
}