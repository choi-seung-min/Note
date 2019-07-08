package com.example.note.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.note.R
import com.example.note.contract.MainContract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , MainContract.View{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolBar()

    }

    override fun setToolBar() {
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }
}