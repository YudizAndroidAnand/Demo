package com.example.myapplication

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.PathInterpolator
import android.widget.Button
import android.widget.ImageView
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FlingAnimation
import java.nio.file.Path

class AnimationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animations)
        findViewById<Button>(R.id.btnBlink).setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this,R.anim.blink)
            val imageview = findViewById<ImageView>(R.id.imageviewGooglePic)
            imageview.startAnimation(animation)
        }
        findViewById<Button>(R.id.btnZoom).setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this,R.anim.rotate)
            val imageview = findViewById<ImageView>(R.id.imageviewGooglePic)
            imageview.startAnimation(animation)
        }
        findViewById<Button>(R.id.btnBounce).setOnClickListener {
            val animation1 = AnimationUtils.loadAnimation(this,R.anim.bounce)
            val imageview = findViewById<ImageView>(R.id.imageviewGooglePic)
            imageview.startAnimation(animation1)
        }
//        findViewById<Button>(R.id.btn).setOnClickListener {
//            val animation1 = AnimationUtils.loadAnimation(this, R.anim.moverightside)
//            val imageview = findViewById<ImageView>(R.id.imageviewGooglePic)
//            imageview.startAnimation(animation1)
//        }
        findViewById<Button>(R.id.btn).setOnClickListener{

        }
    }
}