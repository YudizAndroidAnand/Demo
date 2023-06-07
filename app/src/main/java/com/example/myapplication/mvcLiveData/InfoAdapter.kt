package com.example.myapplication.mvcLiveData

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class InfoAdapter(var newList: List<NewRes.Article>): RecyclerView.Adapter<InfoAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_news_row, parent, false)
        return MyViewHolder(itemView)
    }
    override fun getItemCount(): Int {
        return newList.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleName : TextView = itemView.findViewById(R.id.textview_news)
    }
}