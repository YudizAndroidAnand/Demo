package com.example.myapplication.recycleView
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class Adapter(val context: Context, private var userlist: MutableList<Userdata>):RecyclerView.Adapter<Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_row, parent, false)
        return MyViewHolder(itemView)
    }
    override fun getItemCount(): Int {
        return userlist.size
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentposition = userlist[position]
        holder.username.text = currentposition.name
        holder.usermobilenumber.text = currentposition.mobilenumber
        holder.useremail.text = currentposition.email
        holder.checkboxbtn.isChecked = currentposition.isSelected

        holder.deletebtn.setOnClickListener {
            userlist.remove(userlist[position])
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, userlist.size)

        }
        holder.checkboxbtn.setOnClickListener{
            userlist.set(position,
                Userdata(currentposition.name,currentposition.mobilenumber,currentposition.email,true)
            )
            notifyItemChanged(position)
        }
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val username: TextView = itemView.findViewById(R.id.textviewname)
        val usermobilenumber: TextView = itemView.findViewById(R.id.textviewmobilenumber)
        val useremail: TextView = itemView.findViewById(R.id.textviewemail)
        val deletebtn: Button = itemView.findViewById(R.id.deletebutton)
        val checkboxbtn: CheckBox = itemView.findViewById(R.id.checkbox)
    }
}