package com.example.rafaelanastacioalves.moby.jokeshowing

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View

import com.example.rafaelanastacioalves.moby.R

import timber.log.Timber


class JokeShowingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_package_detail)
        setupActionBar()


        if (savedInstanceState == null) {

            val arguments = Bundle()
            arguments.putString(JokeShowingFragment.ARG_JOKE_CATEGORY,
                    intent.getStringExtra(JokeShowingFragment.ARG_JOKE_CATEGORY))
            val fragment = JokeShowingFragment()
            fragment.arguments = arguments
            supportFragmentManager.beginTransaction()
                    .add(R.id.package_detail_fragment_container, fragment)
                    .commit()


            supportPostponeEnterTransition()
        }
    }

    private fun setupActionBar() {
        val toolbar = findViewById<View>(R.id.detail_toolbar) as Toolbar
        setSupportActionBar(toolbar)

    }

}
