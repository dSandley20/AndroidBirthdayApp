package com.example.happybirthdayapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.happybirthdayapp.models.Dice

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //gets the button and assigns it the variable rollButton
        //still have to do it by the ID assigned in the design window, just happens that its also connected to a int that AS handles.
        val rollButton: Button = findViewById(R.id.Roll_Dice_Button)
        //this serves as a function but without the ()
        rollButton.setOnClickListener {
            val rollResultText: TextView = findViewById(R.id.Dice_Roll_Result)
            //instantiates the dice class and performs the roll function to display random number
            //can also pass it a number of sides
            val dice = Dice(20)
            rollResultText.text = dice.rollDice()
        }


    }
}