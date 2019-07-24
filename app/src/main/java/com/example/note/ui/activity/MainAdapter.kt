package com.example.note.ui.activity

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.note.R
import com.example.note.Task

class MainAdapter (private var item: MutableList<Task>) : RecyclerView.Adapter<MainAdapter.SampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int): SampleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_rv_item, parent, false)
        return SampleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position : Int) {
        val sampleText = item[position]
        holder.sample1.text = sampleText.name
//        holder.sample2.text = sampleText.desc
    }

    fun removeAt(position: Int){
        item.removeAt(position)
        notifyItemRemoved(position)
    }

    class SampleViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var sample1: TextView = view.findViewById(R.id.textView)
//        var sample2: TextView = view.findViewById(R.id.textView2)
    }
}