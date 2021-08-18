package com.example.happybirthdayapp.models

class Dice (private val numSides: Int) {
    private val sides : IntRange = 1..numSides

    fun rollDice (): String {
        return this.sides.random().toString()
    }
}