package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dices are ROLLED Baby!", Toast.LENGTH_SHORT)
            toast.show()
            rollDice()
        }
        val luckyRollButton: Button = findViewById(R.id.button2)
        luckyRollButton.setOnClickListener {
            rollLuckyDice()
        }
    }

    class Dice(private val sides: Int) {
        fun roll(): Int {
            return (1..sides).random()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)

        val resultRoll1 = dice.roll()
        val resultImageView1: ImageView = findViewById(R.id.imageView1) // Find the ImageView in the layout
        resultImageView1.setImageResource(showDice(resultRoll1)) // Update the ImageView with the correct drawable resource ID
        resultImageView1.contentDescription = resultRoll1.toString() // Update the content description

        val resultRoll2 = dice.roll()
        val resultImageView2: ImageView = findViewById(R.id.imageView2)
        resultImageView2.setImageResource(showDice(resultRoll2))
        resultImageView2.contentDescription = resultRoll2.toString()
    }

    private fun showDice(resultRoll1: Int): Int {
        var x = R.drawable.dice_6
        when (resultRoll1) {
            1 -> x = R.drawable.dice_1
            2 -> x = R.drawable.dice_2
            3 -> x = R.drawable.dice_3
            4 -> x = R.drawable.dice_4
            5 -> x = R.drawable.dice_5
        }
        return x
    }

    private fun rollLuckyDice() {
        val dice = Dice(6)
        val resultRoll = dice.roll()
        val resultTextView3: TextView = findViewById(R.id.textView3)
        resultTextView3.text = resultRoll.toString()

        val resultTextView4: TextView = findViewById(R.id.textView4)
        resultTextView4.text = printLuckyDice(resultRoll)
    }

    private fun printLuckyDice(resultRoll: Int) : String {
        val luckyNumber = 4
        when(resultRoll){
            luckyNumber -> return "You won!"
            1 -> return "So sorry! You rolled a 1. Try again!"
            2 -> return "Sadly, you rolled a 2. Try again!"
            3 -> return "Unfortunately, you rolled a 3. Try again!"
            5 -> return "Don't cry! You rolled a 5. Try again!"
            6 -> return "Apologies! You rolled a 6. Try again!"
        }
        return "Dice sides limit Exceeded!"
    }
}