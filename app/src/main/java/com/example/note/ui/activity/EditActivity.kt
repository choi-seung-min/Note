package com.example.note.ui.activity

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.note.R
import com.example.note.contract.EditContract
import com.example.note.data.model.Note
import com.example.note.data.repository.EditRepository
import com.example.note.presenter.EditPresenter
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity(), EditContract.View{

    private val editPresenter = EditPresenter(this, EditRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val data: ArrayList<Note>? = MainActivity.adapter.item
        val position: Int = intent.getIntExtra("position", 0)
        val noteId : Int = intent.getIntExtra("note_id", 0)
        val date : String = intent.getStringExtra("date")
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        if(intent.hasExtra("note_id")){
            editPresenter.flag = false
            edit_title.setText(data?.get(position)?.title)
            edit_contents.setText(data?.get(position)?.content)
            show_date.text = date
            edit_contents.requestFocus()
            imm.showSoftInput(edit_contents, 0)
            //not working when activity is started
        } else{
            Toast.makeText(this, "New Note", Toast.LENGTH_SHORT).show()
            editPresenter.flag = true
            edit_title.requestFocus()
            imm.showSoftInput(edit_title, 0)
            //not working when activity is started
        }

        button_save.setOnClickListener {
            editPresenter.onClickSave(noteId, position)
        }

        button_delete.setOnClickListener {
            editPresenter.onClickDelete(noteId, position)
        }
    }

    override fun showMessageForNewNote() = Toast.makeText(this@EditActivity, "New Note!", Toast.LENGTH_SHORT).show()

    override fun showMessageForEmptyNote() {
        Toast.makeText(this@EditActivity, "note title and contents is empty", Toast.LENGTH_LONG).show()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        edit_title.requestFocus()
        imm.showSoftInput(edit_title, 0)
    }

    override fun showMessageForEmptyTitle() {
        Toast.makeText(this@EditActivity, "note title is empty", Toast.LENGTH_LONG).show()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        edit_title.requestFocus()
        imm.showSoftInput(edit_title, 0)
    }

    override fun showMessageForEmptyContent() {
        Toast.makeText(this@EditActivity, "note contents is empty", Toast.LENGTH_LONG).show()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        edit_contents.requestFocus()
        imm.showSoftInput(edit_contents, 0)
    }

    override fun showMessageForNoteDelete() = Toast.makeText(this@EditActivity, "Note Deleted", Toast.LENGTH_SHORT).show()

    override fun showMessageForNoteDeleteFail(msg: String?) =
        Toast.makeText(this@EditActivity, "Delete Fail\n${msg}", Toast.LENGTH_SHORT).show()

    override fun showMessageForNoteSave() = Toast.makeText(this@EditActivity, "Note saved", Toast.LENGTH_SHORT).show()

    override fun showMessageForNoteSaveFail(msg: String?) =
        Toast.makeText(this@EditActivity, "Note not saved\n${msg}", Toast.LENGTH_SHORT).show()

    override fun getNoteTitle(): String = edit_title.text.toString()

    override fun getNoteContent(): String = edit_contents.text.toString()

    override fun finishActivity()  = finish()
}