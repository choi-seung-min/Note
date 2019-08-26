package com.example.note.contract

import com.example.note.data.repository.EditRepository

interface EditContract{
    interface View{
        fun showMessageForNewNote()
        fun showMessageForNoteDelete()
        fun showMessageForNoteSave()
        fun showMessageForNoteSaveFail()
        fun getNoteTitle() : String
        fun getNoteContent() : String
    }
    interface Presenter{
        fun onClickSave()
        fun onClickDelete()
    }

    interface Repository{
        fun save(title: String, contents: String, date: String, id: String, note_id: String, flag: Boolean, listener: EditRepository.SaveListener)
        fun delete(listener: EditRepository.DeleteListener)
    }
}