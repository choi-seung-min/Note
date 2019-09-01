package com.example.note.presenter

import android.content.Context
import com.example.note.contract.LoginContract
import com.example.note.data.local.PrefHelper
import com.example.note.data.repository.LoginRepository

class LoginPresenter(
    private val loginView: LoginContract.View,
    private val loginRepository: LoginContract.Repository,
    context: Context
) : LoginContract.Presenter {


    val pref = PrefHelper.getInstance(context)

    override fun onClickLogIn() {
        val id = loginView.getId()
        val pw = loginView.getPassword()

        loginRepository.logIn(id, pw, object : LoginRepository.LoginListener {

            override fun onSuccess() {
                loginView.showMessageForLoginSuccess()
                loginView.finishActivity()
                loginView.startNoteActivity()
                pref?.setId(id)
            }

            override fun onFail(msg: String?) {
                loginView.showMessageForLoginFail(msg)
                loginView.clearInputForLoginFail()
            }
        })
    }

    override fun onClickSignup() {
        loginView.startSignupActivity()
    }
}