package com.example.myapplication

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.PathInterpolator
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.ViewCompat
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
            imageview.startAnimation(animation1)
        }
        findViewById<Button>(R.id.btnMoveUp).setOnClickListener{
            val animator =  ObjectAnimator.ofFloat(imageview, "translationY", -300.0f,0.5f)
            animator.duration = 800
            animator.start()
        }
        findViewById<Button>(R.id.btnRotateimage).setOnClickListener{
            val animator =  ObjectAnimator.ofFloat(imageview,  "rotation", 0f, 180f)
            animator.duration = 800
            animator.start()
        }
        findViewById<Button>(R.id.btnSingle).setOnClickListener {
            val intent = Intent(this,SaveFileActivity::class.java)
            val option = ActivityOptions.makeSceneTransitionAnimation(this,carIv, ViewCompat.getTransitionName(carIv))
            startActivity(intent,option.toBundle())
        }

        findViewById<Button>(R.id.btnPair).setOnClickListener {
            val intent = Intent(this,SaveFileActivity::class.java)
            val option = ActivityOptions.makeSceneTransitionAnimation(this, Pair.create(carIv,"m"),Pair.create(carIv,"m"))
            startActivity(intent,option.toBundle())
        }
    }
}