package com.example.jetpack_ex.viewmodel_livedata

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack_ex.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main11)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        findViewById<Button>(R.id.btnArea).setOnClickListener {
            viewModel.plusLiveDataValue()
        }

        viewModel.testLiveData.observe(this, Observer {
            findViewById<TextView>(R.id.textArea).text = it.toString()
        })

//        viewModel.testLiveData.value = 10

//        findViewById<Button>(R.id.btnArea).setOnClickListener {
//            viewModel.plusLiveDataValue()
//        }
//
//        viewModel.testMutableLiveData.observe(this, Observer {
//            findViewById<TextView>(R.id.textArea).text = it.toString()
//        })
//
//        viewModel.testMutableLiveData.value = 10 // MutableLiveData는 값 변경 가능

    }
}