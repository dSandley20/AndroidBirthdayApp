package com.example.happybirthdayapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.happybirthdayapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setting up view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setting up intent/transition to other activities
        //Birthday Activity
        binding.birthdayAppButton.setOnClickListener{
            val intent: Intent = Intent(this, BirthdayActivity::class.java )
            startActivity(intent)
        }
        //Dice Roller Activity
        binding.diceRollButton.setOnClickListener{
            val intent : Intent = Intent(this, DiceRollActivity::class.java)
            startActivity(intent)
        }
        //List View Activity
        binding.listViewButton.setOnClickListener{
            val intent : Intent = Intent(this, ListViewActivity::class.java)
            startActivity(intent)
        }
        //Tip Calculator Activity
        binding.tipCalulatorButton.setOnClickListener{
            val intent : Intent = Intent(this, TipCalculatorActivity::class.java)
            startActivity(intent)
        }
        //Auth Login Activity
        binding.authButton.setOnClickListener{
            val intent : Intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
    }
}