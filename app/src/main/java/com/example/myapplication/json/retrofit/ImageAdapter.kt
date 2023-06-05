package com.example.myapplication.json.retrofit

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.myapplication.R
import com.squareup.picasso.Picasso
import java.util.*

class ImageAdapter(val context : Context, private val imagelist :List<String>) : PagerAdapter(){
    private var layoutInflater: LayoutInflater? = null
    private lateinit var  imgView : ImageView
    private lateinit var imageCount : TextView
    @SuppressLint("SuspiciousIndentation", "MissingInflatedId")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater!!.inflate(R.layout.imageviewpager, container, false)
        imgView = view.findViewById(R.id.image_view_pager)
            Picasso.get().load(imagelist[position]).placeholder(R.drawable.ic_image).into(imgView)
            Objects.requireNonNull(container).addView(view)
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
