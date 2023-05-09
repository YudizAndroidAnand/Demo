package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class Fragment_Home_Fragmate : Fragment(),CommunicteTwoFragment{

    lateinit var textenter : EditText
    lateinit var msg : String
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment__home__fragmate, container, false)

        val btn = view.findViewById<Button>(R.id.homebtnclickme)
         textenter = view.findViewById<EditText>(R.id.entertxt)

        val myinterface : CommunicteTwoFragment = activity as CommunicteTwoFragment

        btn.setOnClickListener {

             msg = textenter.text.toString()

            val intent = Intent(requireContext(),Activity_Fragment::class.java)
            intent.putExtra("xx",msg)
            startActivity(intent) 

            myinterface.sendText(msg)
        }
        return view
    }
    override fun sendText(msg: String) {
        textenter.text.
                val bundle = bundle()

    }
}