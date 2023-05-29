package com.example.myapplication.DemoProject.RecycleView
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DemoProject.TaskTable.Contact
import com.example.myapplication.R
import kotlinx.coroutines.CoroutineScope

class AdapterRecycle(val context: CoroutineScope, private var userlist: MutableList<Contact>):RecyclerView.Adapter<AdapterRecycle.MyViewHolder>() {

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
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleName : TextView = itemView.findViewById(R.id.textview_title)
        val descriptionName :TextView = itemView.findViewById(R.id.textview_description)
    }
}