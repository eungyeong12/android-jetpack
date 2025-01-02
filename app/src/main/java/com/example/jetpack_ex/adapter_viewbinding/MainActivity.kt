package com.example.jetpack_ex.adapter_viewbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpack_ex.databinding.ActivityMain4Binding

// ViewBinding DataBinding
// RecyclerView Adapter findViewById

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMain4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val array = ArrayList<String>()

        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")

        val customAdapter = CustomAdapter(array)

         val rv = binding.rv
        rv.adapter = customAdapter
        rv.layoutManager = LinearLayoutManager(this)
    }
}