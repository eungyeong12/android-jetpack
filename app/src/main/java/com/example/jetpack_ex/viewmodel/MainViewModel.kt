package com.example.jetpack_ex.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

// ViewModel에서 저렇게 아래와 같이 딸랑 변수 하나만 만들어서
// 사용하지는 않고 LiveData 등등 이용해서 함께 씀

// 아래는 예제니깐, 참고~
class MainViewModel : ViewModel() {

    var countValue = 0

    init {
        Log.d("MainViewModel", "init")
    }

    fun plus() {
        countValue++
        Log.d("MainViewModel", countValue.toString())
    }

    fun minus() {
        countValue--
        Log.d("MainViewModel", countValue.toString())
    }

    fun getCount() : Int {
        return countValue
    }
}