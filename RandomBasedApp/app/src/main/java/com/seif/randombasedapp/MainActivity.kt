package com.seif.randombasedapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val animals by lazy {
        listOf(
            Animal(getString(R.string.lion), R.drawable.lion, 6),
            Animal(getString(R.string.tiger), R.drawable.tiger, 5),
            Animal(getString(R.string.bear), R.drawable.bear, 4),
            Animal(getString(R.string.dog), R.drawable.dog, 3),
            Animal(getString(R.string.cat), R.drawable.cat, 7),
            Animal(getString(R.string.rabbit), R.drawable.rabbit, 2),
            Animal(getString(R.string.frog), R.drawable.frog, 1)
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fightButton: Button = findViewById(R.id.fightButton)
        val player1Image: ImageView = findViewById(R.id.player1Image)
        val player2Image: ImageView = findViewById(R.id.player2Image)

        fightButton.setOnClickListener {
            battle(player1Image, player2Image)
        }

    }

    private fun battle(player1Image: ImageView, player2Image: ImageView) {
        val player1Animal = animals.random()
        val player2Animal = animals.random()

        player1Image.setImageResource(player1Animal.imageRes)
        player2Image.setImageResource(player2Animal.imageRes)

        val result = when {
            player1Animal.strength > player2Animal.strength ->
                getString(R.string.player1_wins, player1Animal.name, player2Animal.name)

            player2Animal.strength > player1Animal.strength ->
                getString(R.string.player2_wins, player2Animal.name, player1Animal.name)

            else ->
                getString(R.string.draw, player1Animal.name)
        }
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
    }
}

data class Animal(val name: String, val imageRes: Int, val strength: Int)
