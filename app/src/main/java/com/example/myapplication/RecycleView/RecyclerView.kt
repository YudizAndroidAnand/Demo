package com.example.myapplication.RecycleView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class RecyclerView : AppCompatActivity() {

    private lateinit var newrecyclerView: RecyclerView
    private lateinit var newlist: MutableList<Userdata>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        newrecyclerView = findViewById(R.id.recyclerview)

        newlist = mutableListOf(
            Userdata("anand", "7600740075", "anand@gmail.com",false),
            Userdata("anand1", "7600740075", "anand@gmail.com",false),
            Userdata("anand2", "7600740075", "anand@gmail.com",false),
            Userdata("anand3", "7600740075", "anand@gmail.com",false),
            Userdata("anand4", "7600740075", "anand@gmail.com",false),
            Userdata("anand5", "7600740075", "anand@gmail.com",false),
            Userdata("anand6", "7600740075", "anand@gmail.com",false),
            Userdata("anand7", "7600740075", "anand@gmail.com",false),
            Userdata("anand8", "7600740075", "anand@gmail.com",false),
            Userdata("anand9", "7600740075", "anand@gmail.com",false),
            Userdata("anand10", "7600740075", "anand@gmail.com",false),
            Userdata("anand11", "7600740075", "anand@gmail.com",false),
            Userdata("anand12", "7600740075", "anand@gmail.com",false),
            Userdata("anand13", "7600740075", "anand@gmail.com",false),
            Userdata("anand14", "7600740075", "anand@gmail.com",false),
            Userdata("anand15", "7600740075", "anand@gmail.com",false),
            Userdata("anand16", "7600740075", "anand@gmail.com",false),
            Userdata("anand17", "7600740075", "anand@gmail.com",false)
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


