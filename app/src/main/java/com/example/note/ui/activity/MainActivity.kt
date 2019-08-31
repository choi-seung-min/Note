package com.example.note.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.note.R
import com.example.note.contract.MainContract
import com.example.note.data.model.Note
import com.example.note.data.repository.MainRepository
import com.example.note.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity(), MainContract.View, NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    companion object{
        val adapter: MainAdapter = MainAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainPresenter = MainPresenter(this, MainRepository(), this)

        init()
        mainPresenter.onStarted()
    }

    override fun init() {
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        navigationView.setNavigationItemSelectedListener(this)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
        
        fab.setOnClickListener(this)
    }

    //setting tool bar menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    //click event for tool bar menu buttons
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
            }
            R.id.menu_search -> Snackbar.make(toolbar,"Search menu pressed",Snackbar.LENGTH_SHORT).show()
            R.id.menu_account -> Snackbar.make(toolbar,"Account menu pressed",Snackbar.LENGTH_SHORT).show()
            R.id.menu_logout -> Snackbar.make(toolbar,"Logout menu pressed",Snackbar.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    //click event for navigation drawer buttons
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.account -> Snackbar.make(toolbar, "account pressed", Snackbar.LENGTH_LONG).show()
            R.id.setting -> Snackbar.make(toolbar, "setting pressed", Snackbar.LENGTH_LONG).show()
            R.id.cart -> Snackbar.make(toolbar, "cart pressed", Snackbar.LENGTH_LONG).show()
            R.id.bug_report -> Snackbar.make(toolbar, "but report pressed", Snackbar.LENGTH_LONG).show()
            R.id.star -> Snackbar.make(toolbar, "star pressed", Snackbar.LENGTH_LONG).show()
            R.id.logout -> Snackbar.make(toolbar, "logout pressed", Snackbar.LENGTH_LONG).show()
        }
        drawerLayout.closeDrawers()
        return false
    }

    override fun onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        } else{
            super.onBackPressed()
        }
    }

    override fun addItems(items: ArrayList<Note>?) {
        adapter.item = items
    }

    override fun showMessageForDataLoadingFail() {
        Toast.makeText(this@MainActivity, "Data Loading Failed", Toast.LENGTH_LONG).show()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.fab -> startActivity(Intent(this, EditActivity::class.java))
        }
    }
}