package com.example.happybirthdayapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.happybirthdayapp.databinding.ActivityAuthBinding
import com.example.happybirthdayapp.models.api.Api

class AuthActivity: AppCompatActivity() {
    private lateinit var binding : ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //make API request on button
        binding.authLoginButton.setOnClickListener{
            loginUser()
        }
    }

    fun loginUser(){
        //make api request
        val api = Api(this,)
        api.getRequest( api.getRequestType("GET") ,"/users")
        api.makeRequest(api.getRequestType("POST"), "/authenticate")
    }
}