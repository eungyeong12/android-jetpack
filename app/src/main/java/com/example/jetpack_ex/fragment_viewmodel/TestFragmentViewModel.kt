package com.example.jetpack_ex.fragment_viewmodel

import androidx.lifecycle.ViewModel

class TestFragmentViewModel : ViewModel() {

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