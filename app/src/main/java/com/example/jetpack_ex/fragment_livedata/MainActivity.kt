package com.example.jetpack_ex.fragment_livedata

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jetpack_ex.R
import com.example.jetpack_ex.databinding.ActivityMain12Binding
import com.example.jetpack_ex.fragment_viewmodel.TestFragment

// Fragment LiveData / viewLifeCycleOwner

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMain12Binding

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain12Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val transaction = manager.beginTransaction()
            val fragment = BlankFragment1()
            transaction.replace(R.id.frameArea, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.btn2.setOnClickListener {
            val transaction = manager.beginTransaction()
            val fragment = BlankFragment2()
            transaction.replace(R.id.frameArea, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}