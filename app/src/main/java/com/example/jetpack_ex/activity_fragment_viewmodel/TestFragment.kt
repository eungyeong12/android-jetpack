package com.example.jetpack_ex.activity_fragment_viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.jetpack_ex.R
import com.example.jetpack_ex.databinding.FragmentTest4Binding


class TestFragment : Fragment() {

    private lateinit var binding : FragmentTest4Binding
    private val viewModel : MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test4, container, false)

        binding.fragmentTest.text = viewModel.getCount().toString()

        return binding.root
    }
}