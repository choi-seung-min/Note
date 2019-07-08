package com.example.note.contract

interface MainContract{
    interface View{
        fun setToolBar()
    }

    interface Presenter{
        fun todo()
    }

    interface Repository{
        fun todo()
    }
}