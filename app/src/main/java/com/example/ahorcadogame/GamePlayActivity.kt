package com.example.ahorcadogame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import android.graphics.Color
import android.widget.TextView
import android.widget.ImageView
import android.util.Log

class GamePlayActivity : AppCompatActivity() {

    val word = "Navidad"  // La palabra a adivinar (tiene que ser un parametro que reciba)
    var letters = 0  // Contador de letras acertadas
    var misses = 0  // Contador de letras acertadas
    var allowedErrors = 6; //esto tiene que depender de la dificultad
    var endGame = false
    val numLetters = word.length
    val acertadas = CharArray(numLetters) { '_' }  // Array para mostrar las letras acertadas
    val numlettersToWin = numLetters - 1;

    //Texto a adivinar "___"
    //lateint es para que se inicialice despues de que se cree el layout
    lateinit var wordTextView: TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_play)

        // Encuentra el diseño raíz
        val GamePlayLayout: View = findViewById(R.id.gamePlayLayout)


        //Imager Win
        val imageWin = findViewById<ImageView>(R.id.WinMessage)
        val imageLose = findViewById<ImageView>(R.id.LoseMessage)

        imageWin.visibility = View.INVISIBLE
        imageLose.visibility = View.INVISIBLE

        wordTextView = findViewById(R.id.wordTextView)

        // Inicializar la palabra con "_"
        for (i in acertadas.indices) {
            acertadas[i] = '_'

        }

        wordTextView.text = acertadas.joinToString(" ")


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

                if (endGame) {
                    // Si el juego ha terminado, no se hacen más acciones
                    return@OnClickListener
                }
                    val letter = view.text.toString()

                    processGuess(letter)

                    wordTextView.text = acertadas.joinToString(" ")

                    view.setBackgroundColor(Color.parseColor("#808080"))
                    view.isEnabled = false

                    // Verificar si el jugador ha ganado
                    if (letters >= numlettersToWin) {

                        imageWin.visibility = View.VISIBLE
                        endGame = true
                    }
                    if(misses >= allowedErrors)
                    {
                        imageLose.visibility = View.VISIBLE
                        endGame = true
                    }




            }

        }

        // Asignar el mismo OnClickListener a todos los botones en la lista
        for (button in buttons) {
            button.setOnClickListener(buttonClickListener)
        }

        //Pulsar en cualquier lado de la pantalla para cambiar a main
        GamePlayLayout.setOnClickListener {
            if (endGame) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }



    }

    private fun processGuess(letter: String) {
        var correctGuess = false

        for (i in word.indices) {
            if (word[i].toString().equals(letter, ignoreCase = true)) {
                acertadas[i] = word[i]
                letters ++
                correctGuess = true
            }
        }
        if(!correctGuess)
        {
            misses++
        }
    }
}