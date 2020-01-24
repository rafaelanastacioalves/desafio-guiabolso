package com.example.rafaelanastacioalves.moby.jokeshowing


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.example.rafaelanastacioalves.moby.R
import com.example.rafaelanastacioalves.moby.domain.model.Joke
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

import butterknife.BindView
import butterknife.ButterKnife


class JokeShowingFragment : Fragment(), View.OnClickListener {

    lateinit private var mJokeShowingViewModel: JokeShowingViewModel

    @BindView(R.id.detail_entity_detail_name)
    lateinit internal var tripPackageDetailValor: TextView

    @BindView(R.id.trip_package_detail_imageview)
    lateinit internal var tripPackageDetailImageview: ImageView

    lateinit var categoryName: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribe()
        loadData()
        setupActionBarWithTitle(categoryName)
    }


    private fun loadData() {
        categoryName = arguments!!.getString(ARG_JOKE_CATEGORY)
        mJokeShowingViewModel.loadData(categoryName)
    }

    private fun subscribe() {
        mJokeShowingViewModel = ViewModelProviders.of(this).get(JokeShowingViewModel::class.java)
        mJokeShowingViewModel.jokeDetails.observe(this, Observer { entityDetails -> setViewsWith(entityDetails!!) })

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflateViews(inflater, container)
    }


    private fun inflateViews(inflater: LayoutInflater, container: ViewGroup?): View {
        val rootView = inflater.inflate(R.layout.fragment_detail_entity_detail_view, container, false)
        ButterKnife.bind(this, rootView)
        return rootView
    }


    private fun setupActionBarWithTitle(title: String) {
        val mActivity = activity as AppCompatActivity?
        val actionBar = mActivity!!.supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = title
        }
    }

    private fun setViewsWith(joke: Joke) {

        tripPackageDetailValor!!.text = joke.value
        Picasso.get()
                .load(joke.iconUrl)
                .into(tripPackageDetailImageview, object : Callback {
                    override fun onSuccess() {
                        activity!!.supportStartPostponedEnterTransition()
                    }

                    override fun onError(e: Exception) {

                    }
                })
    }


    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onClick(v: View) {
        Toast.makeText(activity, "Comprado!", Toast.LENGTH_SHORT).show()
    }

    companion object {

        var ARG_JOKE_CATEGORY: String? = null
    }


}// Required empty public constructor
