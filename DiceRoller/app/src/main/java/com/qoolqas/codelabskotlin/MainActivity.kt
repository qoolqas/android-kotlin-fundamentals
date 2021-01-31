package com.qoolqas.codelabskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

const val dice1_KEY = "dice1"
const val dice2_KEY = "dice2"

class MainActivity : AppCompatActivity() {
    private var dice1 = 0
    private var dice2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            dice1 = savedInstanceState.getInt(dice1_KEY, 0)
            dice2 = savedInstanceState.getInt(dice2_KEY, 0)
            getDice()
        }
        roll_button.setOnClickListener {
            rollDice()
        }
        reset_button.setOnClickListener {
            clearDice()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(dice1_KEY, dice1)
        outState.putInt(dice2_KEY, dice2)
    }

    private fun getRandomDiceImage(): Int {
        val randomInt = (1..6).random()
        dice1 = randomInt
        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
    }
    private fun getRandomDiceImage2(): Int {
        val randomInt = (1..6).random()
        dice2 = randomInt
        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
    }


    private fun getDiceImage(int: Int): Int {
        return when (int) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
    }

    private fun rollDice() {

        dice_image.setImageResource(getRandomDiceImage())
        dice_image2.setImageResource(getRandomDiceImage2())

    }

    private fun getDice() {
        dice_image.setImageResource(getDiceImage(dice1))
        dice_image2.setImageResource(getDiceImage(dice2))


    }

    private fun clearDice() {
        dice_image.setImageResource(R.drawable.empty_dice)
        dice_image2.setImageResource(R.drawable.empty_dice)
    }
}