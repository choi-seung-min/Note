package com.example.note.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.note.R
import com.example.note.Task
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        button_save.setOnClickListener {
            val editData = Task(edit_title.text.toString(), edit_contents.text.toString())
            MainActivity.adapter.insert(editData)
            finish()
        }
    }
}