package com.example.note.presenter

import com.example.note.contract.LoginContract
import com.example.note.data.repository.LoginRepository

class LoginPresenter(
    private val loginView: LoginContract.View,
    private val loginRepository: LoginContract.Repository
) : LoginContract.Presenter {

    override fun onClickLogIn() {
        val id = loginView.getId()
        val pw = loginView.getPassword()

        loginRepository.logIn(id, pw, object : LoginRepository.LoginListener {

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
}