package com.example.myapplication.Fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.PassingData
import com.example.myapplication.R

class FragmentForHome : Fragment() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment__home_1, container, false)

        val communication : CommunicteTwoFragment = activity as CommunicteTwoFragment
       // val A = CommunicteTwoFragment()
        val nametext : EditText = view.findViewById(R.id.edittext)
        view.findViewById<Button>(R.id.btn).setOnClickListener {
            val name = nametext.text.toString()
            communication.sendText(name)

        }
        return view
    }
}