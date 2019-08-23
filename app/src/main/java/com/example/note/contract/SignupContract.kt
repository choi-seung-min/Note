package com.example.note.contract

interface SignupContract {
    interface View{
        fun showMessageForSignupSuccess()
        fun showMessageForSignupFail()
    }

    interface Presenter{
        fun onClickSignup()
    }

    interface Repository{
        fun Signup()
    }
}