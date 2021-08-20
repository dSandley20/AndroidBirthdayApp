package com.example.happybirthdayapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.happybirthdayapp.databinding.ActivityDiceRollBinding
import com.example.happybirthdayapp.models.Dice

class DiceRollActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDiceRollBinding

    /**
     * function to update the textView by passing in the number generated
     * @param rolledNumber random number generated by the dice class
     */
    private fun updateRolledText(rolledNumber: Int) {
        //switch statement for conditional render of dice image
        val diceImage : ImageView = findViewById(R.id.dice_image)
        val selectedImage = when(rolledNumber){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> {
                R.drawable.dice_6
            }
        }
        //set new image and alt text
        diceImage.setImageResource(selectedImage)
        diceImage.contentDescription = rolledNumber.toString()
    }

    /**
     *function to compare rolled number vs lucky number
     *@param rolledNumber random number generated by the dice class
     *@param luckyNumber random number that's generated by the main page
     */
    private fun checkLuckyNumber(rolledNumber: Int, luckyNumber: Int, resultToast: Toast) {

        //checks for the lucky number
        when (rolledNumber) {
            luckyNumber -> resultToast.setText("Congrats!")
            else -> {
                resultToast.setText("You rolled: $rolledNumber |  AI rolled: $luckyNumber")
            }
        }
        resultToast.show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiceRollBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.RollDiceButton.setOnClickListener{
            val dice = Dice(6)
            val diceRange: IntRange = 1..6
            val diceNumber: Int = dice.rollDice()
            val aiNumber: Int = diceRange.random()
            val resultToast: Toast = Toast.makeText(this, "", Toast.LENGTH_LONG)
            resultToast.cancel()
            checkLuckyNumber(diceNumber, aiNumber, resultToast)
            updateRolledText(diceNumber)
        }
    }
}