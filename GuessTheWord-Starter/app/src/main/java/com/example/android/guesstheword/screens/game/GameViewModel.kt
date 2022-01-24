package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    init {
        Log.i("GameViewModel", "GameViewModel created!")
        resetList()
        nextWord()
    }
    override fun onCleared(){
        super.onCleared()
        Log.i("GameViewModel","GameViewModel Cleared")
    }

    var word=""
    var score=0
    private lateinit var wordList:MutableList<String>

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }

    /** Methods for buttons presses **/

    fun onSkip() {
        score--
        nextWord()
    }

    fun onCorrect() {
        score++
        nextWord()
    }

    /**
     * Moves to the next word in the list.
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (!wordList.isEmpty()) {
            word = wordList.removeAt(0)
        }
    }
}