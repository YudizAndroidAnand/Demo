package com.example.myapplication

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.PathInterpolator
import android.widget.Button
import android.widget.ImageView
import java.nio.file.Path

class AnimationsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animations)
        val imageview : ImageView = findViewById(R.id.imageviewGooglePic)

        findViewById<Button>(R.id.btnBlink).setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this,R.anim.blink)
            imageview.startAnimation(animation)
        }
        findViewById<Button>(R.id.btnRotate).setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this,R.anim.rotate)
            imageview.startAnimation(animation)
        }
        findViewById<Button>(R.id.btnBounce).setOnClickListener {
            val animation1 = AnimationUtils.loadAnimation(this,R.anim.bounce)
            imageview.startAnimation(animation1)
        }
        findViewById<Button>(R.id.btnMoveRightSide).setOnClickListener {
            val animation1 = AnimationUtils.loadAnimation(this, R.anim.moverightside)
            val imageview = findViewById<ImageView>(R.id.imageviewGooglePic)
            imageview.startAnimation(animation1)
        }
        findViewById<Button>(R.id.btnMoveUp).setOnClickListener{
            val animator =  ObjectAnimator.ofFloat(imageview, "translationY", -300.0f,0.5f)
            animator.duration = 800
            animator.start()
        }
        findViewById<Button>(R.id.btnMoveUp).setOnClickListener{
            val animator =  ObjectAnimator.ofFloat(imageview,  "rotation", 0f, 180f)
            animator.duration = 800
            animator.start()
        }
    }
}