package com.example.happybirthdayapp.models

class Dice (private val numSides: Int) {
    private val sides : IntRange = 1..numSides

    fun rollDice (): Int {
        return this.sides.random()
    }
}