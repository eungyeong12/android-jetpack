package com.example.jetpack_ex.viewmodel_factory

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack_ex.R
import com.example.jetpack_ex.activity_fragment_viewmodel.MainViewModel

// ViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel
    lateinit var viewModelFactory : MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewModelFactory = MainViewModelFactory(5000)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }
}