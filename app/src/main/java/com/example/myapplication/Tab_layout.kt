package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.tablayout.Viewadapter
import com.google.android.material.tabs.TabLayout

class Tab_layout : AppCompatActivity() {

    var tabLayout: TabLayout? = null
    var viewPage : ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)


        tabLayout = findViewById(R.id.tablayout)
        viewPage = findViewById(R.id.viewPage)


        tabLayout!!.addTab(tabLayout!!.newTab().setText("People"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Group"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Call"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        viewPage!!. addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        myadapter()
        Changeviewpage()
    }

    fun myadapter(){
        var  aadapter = Viewadapter(this,supportFragmentManager,tabLayout!!.tabCount)
        viewPage!!.adapter = aadapter
    }

    fun Changeviewpage(){
        tabLayout!!.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

                if (tab != null) {
                    viewPage!!.currentItem = tab.position
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.setIcon(null)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }
}