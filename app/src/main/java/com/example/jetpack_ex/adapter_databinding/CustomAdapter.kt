package com.example.jetpack_ex.adapter_databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack_ex.R
import com.example.jetpack_ex.databinding.TextRowItem2Binding

class CustomAdapter(private val dataSet : ArrayList<String>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(binding : TextRowItem2Binding) : RecyclerView.ViewHolder(binding.root) {

        val myText : TextView = binding.myText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = DataBindingUtil.inflate<TextRowItem2Binding>(LayoutInflater.from(parent.context), R.layout.text_row_item2, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.myText.text = dataSet[position]
    }
}