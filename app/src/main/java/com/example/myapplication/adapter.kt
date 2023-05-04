package com.example.myapplication
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
class adapter(private var userlist:MutableList<userdata>):RecyclerView.Adapter<adapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_row, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentposition = userlist[position]
        holder.username.text = currentposition.name
        holder.usermobilenumber.text = currentposition.mobilenumber
        holder.useremail.text = currentposition.email


        holder.deletebtn.setOnClickListener {

            notifyItemRemoved(position)
            notifyItemRangeChanged(position, userlist.size)
            userlist.remove(userlist[position])

        }
        if(holder.checkboxbtn.isSelected==false){
            holder.checkboxbtn.setOnClickListener {
            holder.alldeletebtn.setOnClickListener {
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, userlist.size)
                userlist.remove(userlist[position])
            }
            }
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val username: TextView = itemView.findViewById(R.id.textviewname)
        val usermobilenumber: TextView = itemView.findViewById(R.id.textviewmobilenumber)
        val useremail: TextView = itemView.findViewById(R.id.textviewemail)
        val deletebtn: Button = itemView.findViewById(R.id.deletebutton)
        val checkboxbtn: CheckBox = itemView.findViewById(R.id.checkbox)
        val alldeletebtn: Button = itemView.findViewById(R.id.alldeletebutton)
    }
}