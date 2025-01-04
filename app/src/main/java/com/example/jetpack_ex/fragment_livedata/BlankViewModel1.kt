package com.example.jetpack_ex.fragment_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlankViewModel1 : ViewModel() {

    private var _mutableCount = MutableLiveData(0)
    val liveCount : LiveData<Int>
        get() = _mutableCount

    fun plusCountValue() {
        _mutableCount.value = _mutableCount.value?.plus(1)
    }
}