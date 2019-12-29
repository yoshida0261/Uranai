package com.stah.uranai

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View.ALPHA
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setImageResource(R.drawable.panda1)

        //findViewById(R.id.monster).startAnimation(AnimationUtils.loadAnimation(this, R.anim.a1));
        imageView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.updown))
        imageView.setOnClickListener {
            val fadeAltAnim = ObjectAnimator.ofFloat(it, "alpha", 0.0f)
            fadeAltAnim.start()
        }

//        val fadeAnim = ObjectAnimator.ofFloat(imageView, "alpha", 0.2f)
        //      fadeAnim.start()
    }
}
