package com.example.note.contract

import com.example.note.data.model.Note
import com.example.note.data.repository.MainRepository

interface MainContract{
    interface View{
        fun init()
        fun addItems(items: ArrayList<Note>?)
        fun showMessageForDataLoadingFail(t: Throwable?)
    }

    interface Presenter{
        fun onStarted()
    }

    interface Repository{
        fun getNoteList(id: String?, listener: MainRepository.GetNotesListener)
    }
}