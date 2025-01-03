package com.example.jetpack_ex.viewmodel

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jetpack_ex.R

// ViewModel

// 안드로이드의 생명 주기를 관리하기 쉽다.

// onSaveInstanceState() 사용해서 데이터를 관리할 수 있지만,
// 적절하지 않다.

// 안드로이드의 생명 주기를 관리하기 쉽다는 말과 같은 말인데
// 상태(LifeCycle)가 변경될 때마다 데이터를 관리해줘야 하는데
// 이 관리가 편하다

// UI컨트롤러(Activity, Fragment)에서 모든 것을 다 하려고 하면 복잡해진다.
// 그래서 ViewModel을 사용하면 테스트나 관리가 용이하다.

class MainActivity : AppCompatActivity() {

    private var countValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main6)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d("MainActivity", "onCreate")

        val plusBtn : Button = findViewById(R.id.plus);
        val minusBtn : Button = findViewById(R.id.minus)

        val resultArea : TextView = findViewById(R.id.result)

        plusBtn.setOnClickListener {
            countValue++
            resultArea.text = countValue.toString()
        }

        minusBtn.setOnClickListener {
            countValue--
            resultArea.text = countValue.toString()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }
}