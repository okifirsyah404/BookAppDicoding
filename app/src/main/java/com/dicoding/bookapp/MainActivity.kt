package com.dicoding.bookapp

import android.os.Bundle
import android.os.Parcelable
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvBooks: RecyclerView
    private var list: ArrayList<Book> = arrayListOf()

    private fun initComponents() {
        rvBooks = findViewById(R.id.rv_books)
    }

    companion object {
        private const val STATE_MODE = "state_mode"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()

        rvBooks.setHasFixedSize(true)
        list.addAll(BooksData.listData)

        if (savedInstanceState != null) {
            val itemLayout = savedInstanceState.getParcelable<Parcelable>(STATE_MODE)
            showRecyclerGrid()
            rvBooks.layoutManager?.onRestoreInstanceState(itemLayout)
        } else {
            showRecyclerList()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val stateMode = rvBooks.layoutManager?.onSaveInstanceState()
        outState.putParcelable(STATE_MODE, stateMode)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_profile -> {
//            val profileIntent = Intent(this@MainActivity, ProfileActivity::class.java)
//            startActivity(profileIntent)
            true
        }
        R.id.action_list -> {
            showRecyclerList()
            true
        }
        R.id.action_grid -> {
            showRecyclerGrid()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun showRecyclerList() {
        rvBooks.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        rvBooks.adapter = ListBookAdapter(list)
    }

    private fun showRecyclerGrid() {
        rvBooks.layoutManager = androidx.recyclerview.widget.GridLayoutManager(this, 2)
        rvBooks.adapter = GridBookAdapter(list)
    }
}