package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

/**
 * @author Omar Mulla Ibrahim
 * Student Nr 500766035
 */

class HigherLowerActivity : AppCompatActivity() {


    // variable to use in the app
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()

    }

    // Set the initial (UI) state of the game.
    private fun initViews(){
        higherBtn.setOnClickListener { onHigherClick() }
        lowerBtn.setOnClickListener { onLowerClick() }
        equalBtn.setOnClickListener { onEqualClick() }
        updateUI()

    }

    // call rollDice on higher and check if he answer is correct
    private fun onHigherClick(){
        rollDice()
        if (currentThrow > lastThrow) onAnswerCorrect()
        else onAnswerIncorrec()

    }
    // call rollDice on lower and check if he answer is correct
    private  fun onLowerClick () {
        rollDice()
        if (currentThrow < lastThrow) onAnswerCorrect()
        else onAnswerIncorrec()

    }
    // call rollDice on equal and check if he answer is correct
    private  fun onEqualClick() {
        if (currentThrow == lastThrow) onAnswerCorrect()
        else onAnswerIncorrec()

    }
    // update UI when the rollDice higher or equal or lower
    private fun updateUI() {
        //   last throw value
        tvlastThrow.text = getString(R.string.last_throw, lastThrow)
        // set the dice images
        when (currentThrow) {
            1 -> ivDice.setImageResource(R.drawable.dice1)
            2 -> ivDice.setImageResource(R.drawable.dice2)
            3 -> ivDice.setImageResource(R.drawable.dice3)
            4 -> ivDice.setImageResource(R.drawable.dice4)
            5 -> ivDice.setImageResource(R.drawable.dice5)
            6 -> ivDice.setImageResource(R.drawable.dice6)
        }
    }
    // call rollDice random range from 1 to 6 an call update UI
    private fun rollDice() {
        lastThrow = currentThrow
        // get random throw
        currentThrow = (1..6).random()
        updateUI()
    }
// Displays a successful Toast message

    private fun onAnswerCorrect () {
        Toast.makeText(this, getString(R.string.correct) , Toast.LENGTH_SHORT).show()

    }
    // Displays a incorrect Toast message
    private  fun  onAnswerIncorrec() {
        Toast.makeText(this,getString(R.string.incorrect), Toast.LENGTH_SHORT).show()

    }

}
