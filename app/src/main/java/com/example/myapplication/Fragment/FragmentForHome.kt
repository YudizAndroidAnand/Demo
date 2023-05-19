package com.example.myapplication.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R

class FragmentForHome : Fragment() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment__home_1, container, false)
        val obj = object : CommunicteTwoFragment {
            override fun sendText(msg: String) {
            }
        }
        val nametext : EditText = view.findViewById(R.id.edittext)
        view.findViewById<Button>(R.id.btn).setOnClickListener {
            obj.sendText(nametext.text.toString())
        }
        return view
    }
}