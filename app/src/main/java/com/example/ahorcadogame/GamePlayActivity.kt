package com.example.ahorcadogame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import android.graphics.Color

class GamePlayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_play)

        // Lista de botones a los que les queremos asignar el mismo Listener
        val buttons = arrayOf(
            findViewById<Button>(R.id.buttonA),
            findViewById<Button>(R.id.buttonB),
            findViewById<Button>(R.id.buttonC),
            findViewById<Button>(R.id.buttonD),
            findViewById<Button>(R.id.buttonE),
            findViewById<Button>(R.id.buttonF),
            findViewById<Button>(R.id.buttonG),
            findViewById<Button>(R.id.buttonH),
            findViewById<Button>(R.id.buttonI),
            findViewById<Button>(R.id.buttonJ),
            findViewById<Button>(R.id.buttonK),
            findViewById<Button>(R.id.buttonL),
            findViewById<Button>(R.id.buttonM),
            findViewById<Button>(R.id.buttonN),
            findViewById<Button>(R.id.buttonÑ),
            findViewById<Button>(R.id.buttonO),
            findViewById<Button>(R.id.buttonP),
            findViewById<Button>(R.id.buttonQ),
            findViewById<Button>(R.id.buttonR),
            findViewById<Button>(R.id.buttonS),
            findViewById<Button>(R.id.buttonT),
            findViewById<Button>(R.id.buttonU),
            findViewById<Button>(R.id.buttonV),
            findViewById<Button>(R.id.buttonW),
            findViewById<Button>(R.id.buttonX),
            findViewById<Button>(R.id.buttonY),
            findViewById<Button>(R.id.buttonZ)
        )

        //
        val buttonClickListener = View.OnClickListener { view ->

            if (view is Button) {
                view.setBackgroundColor(Color.parseColor("#808080"))
            }
        }

        // Asignar el mismo OnClickListener a todos los botones en la lista
        for (button in buttons) {
            button.setOnClickListener(buttonClickListener)
        }

    }
}