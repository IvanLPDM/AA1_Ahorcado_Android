package com.example.ahorcadogame

import Level
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    var isNight = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.myToolBar)
        setSupportActionBar(toolbar)

        val recyclerView: RecyclerView = findViewById(R.id.levelsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val levels = listOf(
            Level("Navidad"),
            Level("Ola"),
            Level("Mariposas"),
            Level("Fa"),
            Level("Perro"),
            Level("Interlocutor")
            // añadir niveles
        )

        recyclerView.adapter = LevelAdapter(levels) { level ->
            val intent = Intent(this, GamePlayActivity::class.java)
            intent.putExtra("WORD", level.word)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            R.id.setting -> {
                isNight = !isNight
                setAppTheme(isNight)
                item.title = if (isNight) "Day" else "Night"
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setAppTheme(isNight: Boolean) {
        if (isNight)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}