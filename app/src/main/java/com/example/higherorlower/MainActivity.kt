package com.example.higherorlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {


    var randomNum = 0 //sets the random number to a default value of zero


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignRandNum() //function call to assign random number
        createListener() //function call to start listening to the button

    }

    private fun generateRandomNum(): Int {
        val random = java.util.Random(); //creates a java random object
        val min = 1 //minimum random value
        val max = 10 //maximum value
        randomNum = random.nextInt(max + 1 - min) //uses java random object to generate a value between 1 and 10

        return randomNum
    }

    fun assignRandNum() {
        randomNum = generateRandomNum() //assigns the random number
    }

    private fun guessNum() {
        val numToGuess = randomNum //sets the numToGuess to be used in comparisons
        val userGuess: Int =
            Integer.parseInt(numGuess.text.toString()) //pulls the information from the text box and casts it to an Int
        checkGuess(userGuess, numToGuess) //calls check guess with the random number and the guess
    }

    //compares the user guess and the random number and sets the textView accordingly
    private fun checkGuess(userGuess: Int, numToGuess: Int) {
        when {
            userGuess < numToGuess -> {
                lblFeedback.text = "Lower"
            }
            userGuess > numToGuess -> {
                lblFeedback.text = "Higher"
            }
            else -> {
                lblFeedback.text = "Correct"
            }
        }

    }

    //runs the guessNum function when the button is pressed
    private fun createListener() {
        btnGuess.setOnClickListener { guessNum() }
    }
}




