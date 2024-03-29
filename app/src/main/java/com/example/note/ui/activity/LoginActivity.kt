package com.example.note.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.note.R
import com.example.note.contract.LoginContract
import com.example.note.presenter.LoginPresenter
import com.example.note.data.repository.LoginRepository
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginPresenter = LoginPresenter(this, LoginRepository(), this)

        login.setOnClickListener {
            loginPresenter.onClickLogIn()
            //TODO: is it right to call start activity here?
            hideKeyboard()
        }
//        login.setOnFocusChangeListener { v , hasFocus ->  if(hasFocus) hideKeyboard() }

       signup.setOnClickListener {
            loginPresenter.onClickSignup()
       }

        cl.setOnClickListener { hideKeyboard() }
    }

    override fun showMessageForLoginSuccess() = Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

    override fun showMessageForLoginFail(msg: String?) = Toast.makeText(this, "로그인 실패\n${msg}", Toast.LENGTH_SHORT).show()

    override fun clearInputForLoginFail() {
        id.setText("")
        password.setText("")
    }

    override fun getId(): String = id.text.toString()

    override fun getPassword(): String = password.text.toString()

    override fun startNoteActivity() = startActivity(Intent(this, MainActivity::class.java))

    override fun startSignupActivity() = startActivity(Intent(this, SignupActivity::class.java))

    override fun finishActivity() = finish()

    override fun hideKeyboard() {
        val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(id.windowToken, 0)
        imm.hideSoftInputFromWindow(password.windowToken, 0)
    }
}
