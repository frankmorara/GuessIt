package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    var word = MutableLiveData<String>()
    var score = MutableLiveData<Int>()
    private lateinit var wordList: MutableList<String>

    init {
        Log.i("GameViewModel","GameViewModel Created")
        resetList()
        nextWord()
        score.value = 0
        word.value = ""
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel","GameViewModel destroyed")
    }



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
    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
//            gameFinished()
        } else {
            word.value = wordList.removeAt(0)
        }

    }
    fun onSkip() {
        score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        score.value = (score.value)?.plus(1)
        nextWord()
    }

}