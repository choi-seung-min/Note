package com.example.note.ui.activity

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.note.R
import com.example.note.data.model.Note

class MainAdapter : RecyclerView.Adapter<MainAdapter.SampleViewHolder>() {

    var item: ArrayList<Note>? = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int): SampleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_rv_item, parent, false)
        return SampleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if(item == null){
            0
        } else{
            item?.size!!
        }
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position : Int) {
        val sampleText = item?.get(position)
        holder.sample1.text = sampleText?.title
    }

    fun removeAt(position: Int){
        item?.removeAt(position)
        notifyItemRemoved(position)
    }

    fun insert(editData: Note){
        item?.add(editData)
        notifyItemInserted(item!!.size)
    }

    fun replace(editData: Note, position: Int){
        item?.set(position, editData)
        notifyItemChanged(position)
    }

    inner class SampleViewHolder(view : View) : RecyclerView.ViewHolder(view){

        var sample1: TextView = view.findViewById(R.id.textView)

        init {
            view.setOnClickListener {
                val position = adapterPosition
                val intent = Intent(it?.context, EditActivity::class.java)
                intent.putExtra("position", position)
                intent.putExtra("note_id", item?.get(position)?.note_id)
                intent.putExtra("date", item?.get(position)?.last_changed_date)
                it?.context?.startActivity(intent)
                Toast.makeText(it?.context, "clicked ${position+1} item", Toast.LENGTH_LONG).show()
            }
        }
    }
}