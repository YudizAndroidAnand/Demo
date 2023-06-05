package com.example.myapplication.DemoProject.RecycleView
import android.annotation.SuppressLint
import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DemoProject.TaskTable.Contact
import com.example.myapplication.DemoProject.TaskTable.ContactDatabase
import com.example.myapplication.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AdapterRecycle(val context: CoroutineScope, private var userlist: MutableList<Contact>):RecyclerView.Adapter<AdapterRecycle.MyViewHolder>() {

    lateinit var dialogMain : Dialog
    lateinit var titleName : EditText
    lateinit var descriptionName : EditText
    lateinit var cancelButton : Button
    lateinit var addButton : Button
    private lateinit var database : ContactDatabase
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_row_recycle, parent, false)
        return MyViewHolder(itemView)
    }
    override fun getItemCount(): Int {
        return userlist.count()
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentposition = userlist.get(position)
        holder.titleName.text = currentposition.title
        holder.descriptionName.text = currentposition.description
        holder.deletebutton.setOnClickListener {
            GlobalScope.launch{
               // database.contactDao().deleteContact(userlist[position])
            }
        }

    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleName : TextView = itemView.findViewById(R.id.textview_title)
        val descriptionName :TextView = itemView.findViewById(R.id.textview_product_description)
        val editbutton : Button = itemView.findViewById(R.id.button_edit)
        val deletebutton : Button = itemView.findViewById(R.id.button_delete)
    }
//    private fun addTaskDialogBox() {
//        dialogMain = Dialog(this)
//        dialogMain.setContentView(R.layout.add_task_dailog)
//        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
//        titleName = dialogMain.findViewById(R.id.edittext_title)
//        descriptionName = dialogMain.findViewById(R.id.edittext_description)
//        cancelButton = dialogMain.findViewById(R.id.button_cancel)
//        addButton = dialogMain.findViewById(R.id.button_add)
//        dialogMain.window?.setBackgroundDrawableResource(android.R.color.transparent)
//        dialogMain.show()
//        cancelButton.setOnClickListener {
//            dialogMain.dismiss()
//        }
//        addButton.setOnClickListener {
//            if (titleName.text.isEmpty() || descriptionName.text.isEmpty()){
//                if (titleName.text.isEmpty()){
//                    titleName.error = "Enter the title"
//                }
//                else{
//                    descriptionName.error = "Enter the description"
//                }
//            }
//            else{
//
//                GlobalScope.launch{
//                    database.contactDao().insertContact(Contact(0,titleName.text.toString(),descriptionName.text.toString()))
//                }
//                Toast.makeText(this@AdapterRecycle, "add successfully", Toast.LENGTH_SHORT).show()
//                dialogMain.dismiss()
//            }
//        }
//    }
}