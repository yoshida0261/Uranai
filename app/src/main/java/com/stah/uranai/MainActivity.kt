package com.stah.uranai

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ObjectAnimator.ofFloat(daikiti, "alpha", 0.0f)
            .start()

        imageView.setImageResource(R.drawable.panda1)

        //findViewById(R.id.monster).startAnimation(AnimationUtils.loadAnimation(this, R.anim.a1));
        imageView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.updown))
        imageView.setOnClickListener {

            val panda = ObjectAnimator.ofFloat(it, "alpha", 0.0f)
                .setDuration(1000)


            val jinja1 = ObjectAnimator.ofFloat(backgroundJinja, "alpha", 0.0f)
                .setDuration(1000)

            val anime = AnimatorSet()
            anime.playTogether(panda, jinja1)




            val daikiti = ObjectAnimator.ofFloat(daikiti, "alpha", 0.1f, 1.0f)
                .setDuration(3000)
            val jinja2 = ObjectAnimator.ofFloat(backgroundJinja, "alpha", 0.1f, 1.0f)
                .setDuration(3000)


            //anime.playSequentially(anime2)
            anime.start()

            val anime2 = AnimatorSet()
            anime2.playTogether(daikiti, jinja2)
            anime2.startDelay = 1000
            anime2.start()


        }

//        val fadeAnim = ObjectAnimator.ofFloat(imageView, "alpha", 0.2f)
        //      fadeAnim.start()
    }
}
