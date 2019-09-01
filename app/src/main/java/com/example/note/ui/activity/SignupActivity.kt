package com.example.note.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.note.R
import com.example.note.contract.SignupContract
import com.example.note.data.repository.SignupRepository
import com.example.note.presenter.SignupPresenter
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity(), SignupContract.View{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val signupPresenter = SignupPresenter(this, SignupRepository())

        signup_btn_signup.setOnClickListener {
            signupPresenter.onClickSignup()
        }
    }

    override fun showMessageForSignupSuccess() = Toast.makeText(this@SignupActivity, "Signup Success", Toast.LENGTH_LONG).show()

    override fun showMessageForSignupFail(t: Throwable?) =
        Toast.makeText(this@SignupActivity, "Signup Failed\n${t?.message}", Toast.LENGTH_LONG).show()

    override fun getName(): String = signup_et_name.text.toString()

    override fun getId(): String = signup_et_id.text.toString()

    override fun getPassword(): String = signup_et_password.text.toString()
}