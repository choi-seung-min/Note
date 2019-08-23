package com.example.note.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.note.R
import com.example.note.contract.SignupContract
import kotlinx.android.synthetic.main.dialog_signup.*

class SignupActivity : AppCompatActivity(), SignupContract.View{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_signup)

        signup_btn_signup.setOnClickListener {

        }
    }

    override fun showMessageForSignupSuccess() = Toast.makeText(this@SignupActivity, "Signup Success", Toast.LENGTH_LONG).show()

    override fun showMessageForSignupFail() = Toast.makeText(this@SignupActivity, "Signup Failed", Toast.LENGTH_LONG).show()
}