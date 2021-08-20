package com.example.happybirthdayapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.happybirthdayapp.databinding.ActivityBirthdayBinding

class BirthdayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBirthdayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBirthdayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}