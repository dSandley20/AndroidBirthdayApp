package com.example.happybirthdayapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.happybirthdayapp.databinding.ActivityListViewBinding

class ListViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}