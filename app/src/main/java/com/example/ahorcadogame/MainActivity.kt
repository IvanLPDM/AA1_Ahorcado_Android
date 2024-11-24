package com.example.ahorcadogame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import android.util.Log
import android.widget.Button
import android.content.Intent
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    var isNight = false;

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.myToolBar)
        setSupportActionBar(toolbar)

        //Pasar a gameplay
        val botonNivel_1: ImageButton = findViewById(R.id.nivel_1)

        botonNivel_1.setOnClickListener {
            // Abrir GamePlayActivity
            val intent = Intent(this, GamePlayActivity::class.java)
            startActivity(intent)
        }

        val botonNivel_: Button = findViewById(R.id.nivel_)

        botonNivel_.setOnClickListener {
            // Abrir GamePlayActivity
            val intent = Intent(this, GamePlayActivity::class.java)
            startActivity(intent)
        }
    }

    // Sacar el popUp
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    // input menu settings
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.setting -> {
                // Alternar entre "Night" y "Day"
                isNight = !isNight  // Cambiar el estado de "Night" o "Day"
                setAppTheme(isNight)  // Cambiar el tema

                item.title = if (isNight) "Day" else "Night"  // Cambiar el texto del ítem
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Cambiar el tema de la aplicación
    private fun setAppTheme(isNight: Boolean) {
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}