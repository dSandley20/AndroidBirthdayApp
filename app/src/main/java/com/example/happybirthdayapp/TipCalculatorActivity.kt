package com.example.happybirthdayapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.happybirthdayapp.databinding.ActivityTipCalculatorBinding

class TipCalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTipCalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipCalculatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}