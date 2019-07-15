package com.example.note.ui.activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.Menu
import android.view.MenuItem
import com.example.note.R
import com.example.note.Task
import com.example.note.contract.MainContract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, NavigationView.OnNavigationItemSelectedListener{



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

        var mainAdapter = MainAdapter(setData())
        recycler_view.adapter = mainAdapter
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)

        val swipeHandler = object : SwipeToDeleteCallback(this){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, position: Int) {
                val adapter = recycler_view.adapter as MainAdapter
                adapter.removeAt(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recycler_view)
        //TODO: strange after item deleted
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

    fun setData() : MutableList<Task>{
        val dataList : MutableList<Task> = arrayListOf()

        val list1 = Task("1", "hi")
        val list2 = Task("2", "hello")
        val list3 = Task("3", "aloha")
        val list4 = Task("4", "hello world")
        val list5 = Task("5", "something")
        val list6 = Task("6", "anything")
        val list7 = Task("7", "nothing")
        val list8 = Task("8", "eight")
        val list9 = Task("9", "nine")
        val list10 = Task("10", "finish")

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