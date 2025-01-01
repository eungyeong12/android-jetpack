package com.example.jetpack_ex.databinding

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.jetpack_ex.R
import com.example.jetpack_ex.viewbinding.SecondActivity


// DataBinding
// ViewBinding이랑 뭐가 다른가?
// 이름처럼 데이터를 연결해주는 역할을 할 수 있다. (데이터와 같이 결합해서 사용할 수 있음)
// DataBinding + LiveData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)

        binding.dataBindingEx.text = "바뀐 텍스트"
        binding.dataBindingEx.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}