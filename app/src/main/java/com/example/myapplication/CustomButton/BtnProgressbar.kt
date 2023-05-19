package com.example.myapplication.CustomButton
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.example.myapplication.R

class BtnProgressbar : FrameLayout {
     lateinit var  rootlayout : FrameLayout
     lateinit var txtview: TextView
     lateinit var  progressBAR : ProgressBar
     var text = ""
     var  isButtonenabled = true
     var bgColor = 0
     var showingloader = false

    constructor(context: Context) : super(context) {
       initKBtnProgressbar(context)
    }

    constructor(context: Context, attr : AttributeSet?)  : super (context , attr) {
        getfromxml(attr,context)
        initKBtnProgressbar(context)
    }

    constructor(context: Context, attr : AttributeSet? , defStyAttr : Int)  : super (context , attr, defStyAttr) { getfromxml(attr,context)
        initKBtnProgressbar(context)
    }

    private  fun getfromxml(attr: AttributeSet? , context: Context){
        val data = context.obtainStyledAttributes(attr, R.styleable.ButtonProgressBar)
            text = data.getString(R.styleable.ButtonProgressBar_text).toString()
            isButtonenabled = data.getBoolean(R.styleable.ButtonProgressBar_enable,true)
            bgColor = data.getColor(
                R.styleable.ButtonProgressBar_bgcolor,context.resources.getColor(
                    R.color.white
                ))
            data.recycle()
        }
    private fun initKBtnProgressbar(context: Context) {

        LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        LayoutInflater.from(context).inflate(R.layout.btn_progressbar,this,true)
        rootlayout = findViewById(R.id.framerootlayout)
        txtview = findViewById(R.id.txt11)
        progressBAR = findViewById(R.id.progressbar)
        if(text.isNotEmpty()){
            txtview.text = text
        }
        refreshDrawableState()
    }

    fun showingloader(){
        showingloader = true
        txtview.visibility = View.GONE
        progressBAR.visibility = View.VISIBLE
    }
    fun hideloader(){
        showingloader = true
        txtview.visibility = View.VISIBLE
        progressBAR.visibility = View.GONE
    }
}