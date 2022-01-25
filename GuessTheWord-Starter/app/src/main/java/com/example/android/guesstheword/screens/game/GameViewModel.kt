package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private val _word=MutableLiveData<String>() // 변경가능함
     private val _score = MutableLiveData<Int>()
    val word: LiveData<String> // ViewModel 외부에서는 데이터는 읽을 수 있지만, 데이터를 수정할 수는 없어야함
        get() = _word

    val score: LiveData<Int>
        get() = _score

    private lateinit var wordList:MutableList<String>

    private var _eventGameFinish = MutableLiveData<Boolean>() // 게임이 종료되면서 저장되는 데이터
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    init {
        _word.value=""
        _score.value=0//set value
        Log.i("GameViewModel", "GameViewModel created!")
        resetList()
        nextWord()
    }
    override fun onCleared(){
        super.onCleared()
        Log.i("GameViewModel","GameViewModel Cleared")
    }

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
        _score.value= (_score.value)?.minus(1) //null이 아니면 1 감소
        nextWord()
    }

    fun onCorrect() {
        _score.value= (_score.value)?.plus(1)
        nextWord()
    }

    /**
     * Moves to the next word in the list.
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            onGameFinish()
        } else {
            _word.value = wordList.removeAt(0)
        }
    }

    fun onGameFinish(){
        _eventGameFinish.value=true
    }
    fun onGameFinishComplete(){
        _eventGameFinish.value=false
    }
}