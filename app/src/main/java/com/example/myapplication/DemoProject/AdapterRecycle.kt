package com.example.myapplication.DemoProject
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class AdapterRecycle(val context: Context, private var userlist: MutableList<UserDataRecycle>):RecyclerView.Adapter<AdapterRecycle.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_row_recycle, parent, false)
        return MyViewHolder(itemView)
    }
    override fun getItemCount(): Int {
        return userlist.size
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentposition = userlist[position]
        holder.titleName.text = currentposition.title
        holder.descriptionName.text = currentposition.description
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleName : TextView = itemView.findViewById(R.id.textview_title)
        val descriptionName :TextView = itemView.findViewById(R.id.textview_description)
    }
}