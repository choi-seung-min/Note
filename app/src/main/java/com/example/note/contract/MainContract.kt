package com.example.note.contract

interface MainContract{
    interface View{
        fun init()
    }

    interface Presenter{
        fun todo()
    }

    interface Repository{
        fun todo()
    }
}