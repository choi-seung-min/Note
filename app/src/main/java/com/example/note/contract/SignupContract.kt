package com.example.note.contract

import com.example.note.data.repository.SignupRepository

interface SignupContract {
    interface View{
        fun showMessageForSignupSuccess()
        fun showMessageForSignupFail()
        fun getName() : String
        fun getId() : String
        fun getPassword() : String
    }

    interface Presenter{
        fun onClickSignup()
    }

    interface Repository{
        fun Signup(name: String, id: String, password: String, listener: SignupRepository.SignupListener)
    }
}