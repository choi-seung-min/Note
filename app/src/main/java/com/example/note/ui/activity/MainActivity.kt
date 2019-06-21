package com.example.note.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.note.R
import com.example.note.contract.LoginContract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showMessageForLoginSuccess() = Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

    override fun showMessageForLoginFail() = Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()

    override fun clearInputForLoginFail() = id.setText("")

    override fun showMessageForBlankID() = Toast.makeText(this, "ID 입력란이 비어있습니다.", Toast.LENGTH_SHORT).show()

    override fun showMessageForBlankPassword() = Toast.makeText(this, "비밀번호 입력창이 비어있습니다.", Toast.LENGTH_LONG).show()

    override fun showMessageForBlankInput() = Toast.makeText(this, "입력창이 모두 비어있습니다.", Toast.LENGTH_LONG).show()

    override fun getId(): String = id.text.toString()

    override fun getPassword(): String = password.text.toString()

    override fun startNoteActivity() {
        TODO("not implemented") // start main activity
    }

    override fun finishActivity() = finish()
}
