package com.example.myapplication

import android.animation.ObjectAnimator
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import com.example.myapplication.Layout.MainActivity

class AnimationsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animations)
        val imageview : ImageView = findViewById(R.id.imageviewGooglePic)
        val imageviewOther : ImageView = findViewById(R.id.imageviewGooglePic2)

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
            imageview.startAnimation(animation1)
        }
        findViewById<Button>(R.id.btnMoveUp).setOnClickListener{
            val animator =  ObjectAnimator.ofFloat(imageview, "translationY", -300.0f,0.5f)
            animator.duration = 800
            animator.start()
        }
        findViewById<Button>(R.id.btnRotateImage).setOnClickListener{
            val animator =  ObjectAnimator.ofFloat(imageview,  "rotation", 0f, 180f)
            animator.duration = 800
            animator.start()
        }
        findViewById<Button>(R.id.btnSingle).setOnClickListener {
            val intent = Intent(this,TestActivity::class.java)
            val option = ActivityOptions.makeSceneTransitionAnimation(this,imageview,"traName")
            startActivity(intent,option.toBundle())
        }

        findViewById<Button>(R.id.btnPair).setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            val option = ActivityOptions.makeSceneTransitionAnimation(this, Pair(imageview,"traName"),Pair(imageviewOther,"traNameSecond"))
            startActivity(intent,option.toBundle())
        }
    }
}