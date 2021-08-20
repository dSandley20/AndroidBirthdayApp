package com.example.happybirthdayapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.happybirthdayapp.databinding.ActivityDiceRollBinding

class DiceRollActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDiceRollBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiceRollBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}