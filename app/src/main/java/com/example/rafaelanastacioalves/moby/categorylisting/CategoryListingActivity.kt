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
import timber.log.Timber

class CategoryListingActivity : AppCompatActivity(), RecyclerViewClickListener {
    private val mClickListener = this
    private var mTripPackageListAdapter: CategoryAdapter? = null
    private val tripPackageListLoaderId = 10
    private var mRecyclerView: RecyclerView? = null
    lateinit private var mLiveDataMainEntityListViewModel: LiveDataMainEntityListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViews()
        setupRecyclerView()
        subscribe()

    }

    private fun subscribe() {
        mLiveDataMainEntityListViewModel = ViewModelProviders.of(this).get(LiveDataMainEntityListViewModel::class.java!!)
        mLiveDataMainEntityListViewModel.mainEntityList.observe(this, Observer { mainEntities ->
            populateRecyclerView(mainEntities)
        })
    }

    private fun setupViews() {
        setContentView(R.layout.activity_main)
    }

    private fun setupRecyclerView() {
        mRecyclerView = findViewById<View>(R.id.trip_package_list) as RecyclerView
        val layoutManager = LinearLayoutManager(applicationContext)
        mRecyclerView!!.layoutManager = layoutManager
        if (mTripPackageListAdapter == null) {
            mTripPackageListAdapter = CategoryAdapter(this)
        }
        mTripPackageListAdapter!!.setRecyclerViewClickListener(mClickListener)
        mRecyclerView!!.adapter = mTripPackageListAdapter
    }


    private fun populateRecyclerView(data: List<String>?) {
        if (data == null) {
            mTripPackageListAdapter!!.setItems(null)
            //TODO add any error managing

        } else {
            mTripPackageListAdapter!!.setItems(data)
        }

    }


    override fun onClick(view: View, position: Int) {
        val category = mTripPackageListAdapter!!.getItems()!!.get(position)
        redirectToJoke(category)
    }

    private fun redirectToJoke(category: String) {
        val i = Intent(this, JokeShowingActivity::class.java)
        i.putExtra(JokeShowingFragment.ARG_JOKE_CATEGORY, category)
        startActivity(i)
    }
}
