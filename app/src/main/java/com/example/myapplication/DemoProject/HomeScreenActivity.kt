package com.example.myapplication.DemoProject

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.myapplication.DemoProject.RecycleView.AdapterRecycle
import com.example.myapplication.DemoProject.TaskTable.Contact
import com.example.myapplication.DemoProject.TaskTable.ContactDatabase
import com.example.myapplication.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeScreenActivity : AppCompatActivity() {


    private lateinit var database : ContactDatabase
    private lateinit var newrecyclerView: RecyclerView
    lateinit var dialogMain : Dialog
    lateinit var titleName : EditText
    lateinit var descriptionName : EditText
    lateinit var cancelButton : Button
    lateinit var addButton : Button

    @OptIn(DelicateCoroutinesApi::class)
    override  fun onCreate(savedInstanceState: Bundle?) {
        database = Room.databaseBuilder(applicationContext, ContactDatabase::class.java,"contact").build()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        findViewById<Button>(R.id.button_logout).setOnClickListener {
            logoutDialogBox()
        }
        findViewById<FloatingActionButton>(R.id.floating_button_add_task).setOnClickListener{
            addTaskDialogBox()
        }
        GlobalScope.launch {
             val list = database.contactDao().getContact()
            newrecyclerView = findViewById(R.id.recyclerview)
            val myadapter = AdapterRecycle(this, list as MutableList<Contact>)
            newrecyclerView.adapter = myadapter
        }
//        val list = database.contactDao().getContact().toMutableList()

    }


    private fun logoutDialogBox() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("⚠️ Confirm Exit..!!")
        builder.setMessage("Are you sure,You want to logout")
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
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
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
                    titleName.error = "Enter the title"
                }
                else{
                    descriptionName.error = "Enter the description"
                }
            }
            else{

                GlobalScope.launch{
                    database.contactDao().insertContact(Contact(0,titleName.text.toString(),descriptionName.text.toString()))
                }
                Toast.makeText(this, "add successfully", Toast.LENGTH_SHORT).show()
                dialogMain.dismiss()
            }
        }
    }
}