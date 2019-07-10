package com.example.note.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.note.R
import com.example.note.contract.LoginContract
import com.example.note.presenter.LoginPresenter
import com.example.note.repository.LoginRepository
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private val loginPresenter = LoginPresenter(this, LoginRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.setOnClickListener { loginPresenter.onClickLogIn() }
//        login.setOnFocusChangeListener { v , hasFocus ->  if(hasFocus) hideKeyboard() }
        cl.setOnClickListener { hideKeyboard() }
    }

    override fun showMessageForLoginSuccess() = Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

    override fun showMessageForLoginFail() = Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()

    override fun clearInputForLoginFail() {
        id.setText("")
        password.setText("")
    }

    override fun showMessageForBlankID() = Toast.makeText(this, "ID 입력란이 비어있습니다.", Toast.LENGTH_SHORT).show()

    override fun showMessageForBlankPassword() = Toast.makeText(this, "비밀번호 입력창이 비어있습니다.", Toast.LENGTH_LONG).show()

    override fun showMessageForBlankInput() = Toast.makeText(this, "입력창이 모두 비어있습니다.", Toast.LENGTH_LONG).show()

    override fun getId(): String = id.text.toString()

    override fun getPassword(): String = password.text.toString()

    override fun startNoteActivity() = startActivity(Intent(this, MainActivity::class.java))

    override fun finishActivity() = finish()

    override fun hideKeyboard() {
        val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(id.windowToken, 0)
        imm.hideSoftInputFromWindow(password.windowToken, 0)
        //TODO: use when login button clicked
    }
}
