package com.example.note.contract

import com.example.note.data.repository.EditRepository

interface EditContract{
    interface View{
        fun showMessageForNewNote()
        fun showMessageForNoteDelete()
        fun showMessageForNpteSave()
        fun getTitle(): String
        fun getContents(): String
    }
    interface Presenter{
        fun onClickSave()
        fun onClickDelete()
    }

    interface Repository{
        fun save(title: String, contents: String, listener: EditRepository.SaveListener)
        fun delete(listener: EditRepository.DeleteListener)
    }
}