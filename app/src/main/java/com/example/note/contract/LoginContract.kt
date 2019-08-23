package com.example.note.contract

import com.example.note.data.repository.LoginRepository

interface LoginContract{
    interface View{
        fun showMessageForLoginSuccess()
        fun showMessageForLoginFail()
        fun clearInputForLoginFail()
        fun getId() : String
        fun getPassword() : String
        fun startNoteActivity()
        fun finishActivity()
        fun hideKeyboard()
    }
    interface Presenter{
        fun onClickLogIn()
    }

    interface  Repository{
        fun logIn(id : String, password : String, listener : LoginRepository.LoginListener)
    }
}