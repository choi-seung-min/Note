package com.example.note.repository

import com.example.note.contract.LoginContract

class LoginRepository : LoginContract.Repository{

    interface LoginListener{
        fun onSuccess()
        fun onFail()
    }

    override fun logIn(id: String, pw: String, listener: LoginListener) {
        if(id == "example" && pw == "example"){
            listener.onSuccess()
        } else{
            listener.onFail()
        }
    }
}