package com.example.myapplication

import com.example.myapplication.Fragment.FragmentForHome
import com.example.myapplication.Fragment.FragmentForProfile
import com.example.myapplication.Fragment.FragmentForSetting
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.Fragment.CommunicteTwoFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityFragment : AppCompatActivity(),CommunicteTwoFragment {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        bottomNav = findViewById(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener {
            loadFragment(FragmentForHome())

            when (it.itemId) {
                R.id.item_home -> {
                    loadFragment(FragmentForHome())
                    true
                }
                R.id.item_profile -> {
                    loadFragment(FragmentForProfile())
                    true
                }
                R.id.item_setting -> {
                    loadFragment(FragmentForSetting())
                    true
                }

                else -> false
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

    override fun sendText(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}


