package com.example.happybirthdayapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.happybirthdayapp.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    //this makes it so we can just use the binding obj instead of having to find the
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //one liner for
        binding.calculateTipButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip(){
        //get amount for bill
        val billAmount = binding.serviceTextField.text.toString()
        val amount = billAmount.toDouble()
        val tipPercent = when (binding.tipOptions.checkedRadioButtonId){
            R.id.twenty_percent_tip -> 0.20
            R.id.fifteen_percent_tip -> 0.15
            else -> { 0.10 }
        }
        var tip  = amount * tipPercent
        val roundUp = binding.roundTipToggle.isChecked
        if (roundUp){
            tip = kotlin.math.ceil(tip)
        }
        //format the tip
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipAmount.text = " ${getString(R.string.tip_amount)} $formattedTip"


    }
}