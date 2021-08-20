package com.example.happybirthdayapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.happybirthdayapp.databinding.ActivityTipCalculatorBinding
import java.text.NumberFormat

class TipCalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTipCalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipCalculatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
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