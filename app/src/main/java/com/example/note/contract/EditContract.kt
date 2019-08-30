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
        fun finishActivity()
    }
    interface Presenter{
        fun onClickSave(note_id: Int, position: Int)
        fun onClickDelete()
    }

    interface Repository{
        fun save(title: String, contents: String, date: String, id: String?, note_id: Int, flag: Boolean, listener: EditRepository.SaveListener, nListener: EditRepository.NewSaveListener)
        fun delete(listener: EditRepository.DeleteListener)
    }
}