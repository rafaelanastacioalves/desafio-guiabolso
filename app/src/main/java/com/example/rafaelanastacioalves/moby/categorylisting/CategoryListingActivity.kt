package com.example.rafaelanastacioalves.moby.categorylisting

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.rafaelanastacioalves.moby.R
import com.example.rafaelanastacioalves.moby.jokeshowing.JokeShowingActivity
import com.example.rafaelanastacioalves.moby.jokeshowing.JokeShowingFragment
import com.example.rafaelanastacioalves.moby.listeners.RecyclerViewClickListener

class CategoryListingActivity : AppCompatActivity(), RecyclerViewClickListener {
    private val clickListener = this
    private var categoryListingAdapter: CategoryAdapter? = null
    private var recyclerView: RecyclerView? = null
    lateinit private var categoryListingViewModel: CategoryListingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViews()
        setupRecyclerView()
        subscribe()

    }

    private fun subscribe() {
        categoryListingViewModel = ViewModelProviders.of(this).get(CategoryListingViewModel::class.java!!)
        categoryListingViewModel.mainEntityList.observe(this, Observer { mainEntities ->
            populateRecyclerView(mainEntities)
        })
    }

    private fun setupViews() {
        setContentView(R.layout.activity_main)
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById<View>(R.id.trip_package_list) as RecyclerView
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView!!.layoutManager = layoutManager
        if (categoryListingAdapter == null) {
            categoryListingAdapter = CategoryAdapter(this)
        }
        categoryListingAdapter!!.setRecyclerViewClickListener(clickListener)
        recyclerView!!.adapter = categoryListingAdapter
    }


    private fun populateRecyclerView(data: List<String>?) {
        if (data == null) {
            categoryListingAdapter!!.setItems(null)
            //TODO add any error managing

        } else {
            categoryListingAdapter!!.setItems(data)
        }

    }


    override fun onClick(view: View, position: Int) {
        val category = categoryListingAdapter!!.getItems()!!.get(position)
        redirectToJoke(category)
    }

    private fun redirectToJoke(category: String) {
        val i = Intent(this, JokeShowingActivity::class.java)
        i.putExtra(JokeShowingFragment.ARG_JOKE_CATEGORY, category)
        startActivity(i)
    }
}
