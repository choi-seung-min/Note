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
import com.example.note.R
import com.example.note.Task
import com.example.note.contract.MainContract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    override fun init() {
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        navigationView.setNavigationItemSelectedListener(this)

        val mainAdapter = MainAdapter(setData())
        recycler_view.adapter = mainAdapter
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

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.fab -> startActivity(Intent(this, EditActivity::class.java))
        }
    }

    private fun setData() : MutableList<Task>{
        val dataList : MutableList<Task> = arrayListOf()

        val list1 = Task("hi", "wegrsrg")
        val list2 = Task("hello", "sadas")
        val list3 = Task("aloha", "edbggre")
        val list4 = Task("hello world", "asdge")
        val list5 = Task("something", "fvebdjh")
        val list6 = Task("anything", "sakndjkasnd")
        val list7 = Task("nothing", "kfjvnk")
        val list8 = Task("eight", "samdajs")
        val list9 = Task("nine", "sadnkajs")
        val list10 = Task( "finish", "jdnaskd")

        dataList.add(list1)
        dataList.add(list2)
        dataList.add(list3)
        dataList.add(list4)
        dataList.add(list5)
        dataList.add(list6)
        dataList.add(list7)
        dataList.add(list8)
        dataList.add(list9)
        dataList.add(list10)

        return dataList
    }
}