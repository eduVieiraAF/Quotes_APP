package com.example.quotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()

        val splash = findViewById<ImageView>(R.id.IV_splash)
        splash.alpha = 0f

        splash.animate().setDuration(3000).alpha(1f).withEndAction {

            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}