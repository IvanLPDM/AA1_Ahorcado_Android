package com.example.ahorcadogame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import android.graphics.Color
import android.widget.TextView
import android.widget.ImageView
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar

class HardGamePlayActivity : AppCompatActivity() {

    var isNight = false;

    val word = "Mariposas"  // La palabra a adivinar (tiene que ser un parametro que reciba)
    var letters = 0  // Contador de letras acertadas
    var misses = 0  // Contador de letras acertadas
    var allowedErrors = 11;
    var endGame = false
    val numLetters = word.length
    val acertadas = CharArray(numLetters) { '_' }  // Array para mostrar las letras acertadas

    //Texto a adivinar "___"
    //lateint es para que se inicialice despues de que se cree el layout
    private lateinit var wordTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hard_activity_game_play)

        //Toolbar
        val toolbar: Toolbar = findViewById(R.id.myToolBar)
        setSupportActionBar(toolbar)

        // Encuentra el diseño raíz
        val GamePlayLayout: View = findViewById(R.id.hardGamePlayLayout)


        //Imager Win
        val imageWin = findViewById<ImageView>(R.id.WinMessage)
        val imageLose = findViewById<ImageView>(R.id.LoseMessage)

        val ahorcadoImage: ImageView = findViewById(R.id.miss)

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
                    if (letters >= numLetters) {

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
            updateMissImage(misses)
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

    private fun setAppTheme(isNight: Boolean) {
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun updateMissImage(misses: Int) {
        val ahorcadoImage: ImageView = findViewById(R.id.miss)
        val resourceName = "miss$misses"
        val resId = resources.getIdentifier(resourceName, "mipmap", packageName)
        ahorcadoImage.setImageResource(resId)

    }
}