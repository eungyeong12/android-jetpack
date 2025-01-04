package com.example.jetpack_ex.map_switchmap

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack_ex.R
import com.example.jetpack_ex.databinding.ActivityMain13Binding
import com.example.jetpack_ex.viewmodel_livedata.MainViewModel
import com.example.jetpack_ex.map_switchmap.MainViewModel as MainViewModel1

// LiveData Transformations

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMain13Binding
    private lateinit var viewModel : MainViewModel1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main13)
        ViewModelProvider(this).get(MainViewModel1::class.java)
            .also { viewModel = it }

        viewModel.liveCount.observe(this, Observer {
            // 관찰된 값을 가져와서 액티비티에서 변경하는 방식
//            binding.resultArea1.text = (it + it).toString()
//            binding.resultArea1.text = (it * it).toString()
        })

        viewModel.mapLiveData.observe(this, Observer {
            binding.resultArea1.text = it.toString()
        })

        viewModel.switchMapLiveData.observe(this, Observer {
            binding.resultArea2.text = it.toString()
        })

        binding.btnArea.setOnClickListener {
            val count = binding.inputArea.text.toString().toInt()
            viewModel.setLiveDataValue(count)
        }
    }
}