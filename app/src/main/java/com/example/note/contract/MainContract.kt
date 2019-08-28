package com.example.note.contract

import com.example.note.data.repository.MainRepository

interface MainContract{
    interface View{
        fun init()
    }

    interface Presenter{
        fun onStarted()
        fun onClickItem()
    }

    interface Repository{
        fun getNoteList(id: String, listener: MainRepository.GetNotesListener)
    }
}