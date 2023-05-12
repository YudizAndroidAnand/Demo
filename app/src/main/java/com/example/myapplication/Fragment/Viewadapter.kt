package com.example.myapplication.Fragment

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class Viewadapter(private var context : Context, fragmentManager: FragmentManager, var tabs: Int) : FragmentPagerAdapter(
    fragmentManager) {

    override fun getCount(): Int {
        return tabs
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return People_Fragment()
            }

            1 -> {
                return Group_Fragment()
            }

            2 -> {
                return  Call_Fragment()
            }

            else -> {
                return People_Fragment()
            }
        }
    }
}