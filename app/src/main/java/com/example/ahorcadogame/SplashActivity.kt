package com.example.ahorcadogame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Encuentra el diseño raíz
        val splashLayout: View = findViewById(R.id.splash_layout)

        // Configura un listener para detectar toques en cualquier parte del diseño
        splashLayout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Termina la actividad actual
        }
    }
}