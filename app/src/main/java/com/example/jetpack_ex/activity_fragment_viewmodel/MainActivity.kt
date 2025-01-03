package com.example.jetpack_ex.activity_fragment_viewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack_ex.R
import com.example.jetpack_ex.databinding.ActivityMain5Binding
import com.example.jetpack_ex.databinding.ActivityMain8Binding
import com.example.jetpack_ex.fragment_viewmodel.TestFragment
import com.example.jetpack_ex.viewmodel.MainViewModel

// ViewModel -> Activity/Fragmnet 공유
// Why -> Activity의 값을 Fragment 쓰고 싶거나
// Fragment에서 값을 ViewModel의 값으로 사용하기 위해서

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMain8Binding
    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main8)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.resultArea.text = viewModel.getCount().toString()

        binding.plus.setOnClickListener {
            viewModel.plus()
            binding.resultArea.text = viewModel.getCount().toString()
        }

        binding.minus.setOnClickListener {
            viewModel.minus()
            binding.resultArea.text = viewModel.getCount().toString()
        }

        val manager = supportFragmentManager

        binding.showFragment.setOnClickListener {
            val transaction = manager.beginTransaction()
            val fragment = TestFragment()
            transaction.replace(R.id.frameArea, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}