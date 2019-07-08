package com.example.note.contract

import com.example.note.repository.LoginRepository

interface LoginContract{
    interface View{
        fun showMessageForLoginSuccess()
        fun showMessageForLoginFail()
        fun clearInputForLoginFail()
        fun showMessageForBlankID()
        fun showMessageForBlankPassword()
        fun showMessageForBlankInput()
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
        fun logIn(id : String, pw : String, listener : LoginRepository.LoginListener)
    }
}