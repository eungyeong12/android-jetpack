package com.example.jetpack_ex.databinding_data_class

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.jetpack_ex.R
import com.example.jetpack_ex.databinding.ActivityMain3Binding

// DataBinding
// 이름처럼, 뭔가 데이터를 어쩌고 저쩌고 해줄 수 없을까?(연결)
// 데이터 결합

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMain3Binding

    var testCount = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main3)

        val person = Person("개복치", 20)
        binding.user = person
    }

    fun myClick(view : View) {
        Log.d("MainActivity", "onClick")
        testCount++

        val person = Person("개복치", testCount)
        binding.user = person
    }
}
