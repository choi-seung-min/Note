package com.example.note.presenter

import com.example.note.contract.SignupContract
import com.example.note.data.repository.SignupRepository
import com.example.note.ui.activity.SignupActivity

class SignupPresenter (
    private val signupActivity: SignupActivity,
    private val signupRepository: SignupRepository
): SignupContract.Presenter {
    override fun onClickSignup() {
        val name = signupActivity.getName()
        val id = signupActivity.getId()
        val password = signupActivity.getPassword()

        signupRepository.Signup(name, id, password, object : SignupRepository.SignupListener{
            override fun onSuccess() {
                signupActivity.showMessageForSignupSuccess()
                signupActivity.finish()
            }

            override fun onFail(msg: String?) {
                signupActivity.showMessageForSignupFail(msg)
                signupActivity.finish()
            }
        })
    }
}