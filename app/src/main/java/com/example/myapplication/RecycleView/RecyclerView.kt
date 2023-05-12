package com.example.myapplication.RecycleView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class RecyclerView : AppCompatActivity() {

    private lateinit var newrecyclerView: RecyclerView
    private lateinit var newlist: MutableList<userdata>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        newrecyclerView = findViewById(R.id.recyclerview)

        newlist = mutableListOf(
            userdata("anand", "7600740075", "anand@gmail.com",false),
            userdata("anand1", "7600740075", "anand@gmail.com",false),
            userdata("anand2", "7600740075", "anand@gmail.com",false),
            userdata("anand3", "7600740075", "anand@gmail.com",false),
            userdata("anand4", "7600740075", "anand@gmail.com",false),
            userdata("anand5", "7600740075", "anand@gmail.com",false),
            userdata("anand6", "7600740075", "anand@gmail.com",false),
            userdata("anand7", "7600740075", "anand@gmail.com",false),
            userdata("anand8", "7600740075", "anand@gmail.com",false),
            userdata("anand9", "7600740075", "anand@gmail.com",false),
            userdata("anand10", "7600740075", "anand@gmail.com",false),
            userdata("anand11", "7600740075", "anand@gmail.com",false),
            userdata("anand12", "7600740075", "anand@gmail.com",false),
            userdata("anand13", "7600740075", "anand@gmail.com",false),
            userdata("anand14", "7600740075", "anand@gmail.com",false),
            userdata("anand15", "7600740075", "anand@gmail.com",false),
            userdata("anand16", "7600740075", "anand@gmail.com",false),
            userdata("anand17", "7600740075", "anand@gmail.com",false)
        )

        val alldeletebutton: Button = findViewById(R.id.alldeletebtn)
        val myadapter = Adapter(this, newlist)
        newrecyclerView.adapter = myadapter

        alldeletebutton.setOnClickListener {
            Toast.makeText(this, "delete sucessfull", Toast.LENGTH_SHORT).show()
            val checklist = newlist.filter{ it.isSelected }
                 for (i in checklist) {
                    myadapter.notifyItemRemoved(newlist.indexOf(i))
                    myadapter.notifyItemRangeChanged(newlist.indexOf(i), newlist.size)
                    newlist.remove(i)
            }
        }
    }
}


