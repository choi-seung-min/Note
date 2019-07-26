package com.example.note.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.note.R
import com.example.note.Task
import kotlinx.android.synthetic.main.activity_edit.*
import java.util.ArrayList

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        var flag = false
        val data: Task
        var position = 0

        if(intent.hasExtra("data")){
            data = intent.getParcelableExtra("data")
            position = intent.getIntExtra("position", 0)
            edit_title.setText(data.title)
            edit_contents.setText(data.contents)
            flag = true
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
    }
}