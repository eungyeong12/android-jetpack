package com.example.jetpack_ex.activity_fragment_viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var countValue = 0

    fun plus() {
        countValue++
    }

    fun minus() {
        countValue--
    }

    fun getCount() : Int {
        return countValue
    }
}