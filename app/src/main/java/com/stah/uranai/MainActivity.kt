package com.stah.uranai

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 後で表示するので事前にalphaを０にする
        ObjectAnimator.ofFloat(daikiti, "alpha", 0.0f)
            .start()

        panda.startAnimation(AnimationUtils.loadAnimation(this, R.anim.updown))
        panda.setOnClickListener {

            // アニメーションはObjectanimatorで処理　https://techblog.yahoo.co.jp/programming/androidiphone/
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
            anime.start()

            // 簡単なanimeなのでタイミングは手入力
            val anime2 = AnimatorSet()
            anime2.playTogether(daikiti, jinja2)
            anime2.startDelay = 1000
            anime2.start()

        }

    }
}
