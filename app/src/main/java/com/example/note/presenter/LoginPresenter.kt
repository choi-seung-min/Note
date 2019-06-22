package com.example.note.presenter

import android.view.inputmethod.InputMethodManager
import com.example.note.contract.LoginContract
import com.example.note.repository.LoginRepository

class LoginPresenter(
    private val loginView :LoginContract.View,
    private val loginRepository : LoginContract.Repository
) : LoginContract.Presenter{


    override fun onClickLogIn() {
        val id = loginView.getId()
        val pw = loginView.getPassword()

        if(id == ""){
            loginView.showMessageForBlankID()
        } else if (pw == ""){
            loginView.showMessageForBlankPassword()
        } else if(id == "" && pw ==""){
            loginView.showMessageForBlankInput()
        }

        loginRepository.logIn(id, pw, object : LoginRepository.LoginListener{
            override fun onSuccess() {
                loginView.showMessageForLoginSuccess()
                loginView.finishActivity()
                loginView.startNoteActivity()
            }

            override fun onFail() {
                loginView.showMessageForLoginFail()
                loginView.clearInputForLoginFail()
            }

        })
    }

    override fun onClickOther() {}
}