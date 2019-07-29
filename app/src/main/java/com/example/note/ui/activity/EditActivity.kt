package com.example.note.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.note.R
import com.example.note.Task
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        var flag = false
        val data: ArrayList<Task> = MainActivity.adapter.item
        var position = 0

        if(intent.hasExtra("position")){
//            data = intent.getParcelableExtra("data")
            position = intent.getIntExtra("position", 0)
//            edit_title.setText(data.title)
//            edit_contents.setText(data.contents)
            edit_title.setText(data[position].title)
            edit_contents.setText(data[position].contents)
            flag = true
        } else{
            Toast.makeText(this, "New Note", Toast.LENGTH_SHORT).show()
        }

        button_save.setOnClickListener {

            val editData = Task(edit_title.text.toString(), edit_contents.text.toString())

            if(flag){
                MainActivity.adapter.replace(editData, position)
                finish()
            } else{
                MainActivity.adapter.insert(editData)
                finish()
            }
        }

        button_delete.setOnClickListener {
            if(intent.hasExtra("position")){
                MainActivity.adapter.removeAt(position)
                Toast.makeText(this, "item$position deleted", Toast.LENGTH_SHORT).show()
                finish()
            } else{
                Toast.makeText(this, "there's nothing saved", Toast.LENGTH_LONG).show()
            }
        }
    }
}