package com.example.myapplication.Json.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.myapplication.R

class ImageAdapter(val context : Context, private val imagelist :List<String>) : PagerAdapter(){
    private var layoutInflater: LayoutInflater? = null
    private lateinit var  imgview : ImageView
    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        layoutInflater = LayoutInflater.from(context)
        val view =    layoutInflater!!.inflate(R.layout.activity_show_product_data, container, false)
        imgview = view.findViewById(R.id.imageview)
        //   Picasso.get().load(imagelist[position]).into(imgview)
        container.addView(view, position)
        return view
    }
    override fun getCount(): Int {
        return imagelist.size
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return  view == `object`
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}
