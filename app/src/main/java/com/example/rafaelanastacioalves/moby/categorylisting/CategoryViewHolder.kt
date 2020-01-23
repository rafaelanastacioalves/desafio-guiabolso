package com.example.rafaelanastacioalves.moby.categorylisting;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rafaelanastacioalves.moby.R;
import com.example.rafaelanastacioalves.moby.listeners.RecyclerViewClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    @BindView(R.id.trip_package_container)
    lateinit var tripPackageContainer: View
    lateinit private var aRecyclerViewListener: RecyclerViewClickListener

    @BindView(R.id.joke_category_title_textview)
    lateinit var tripPackageTitleTextView: TextView;

    constructor(itemView: View , clickListener: RecyclerViewClickListener) : this(itemView) {
        this.aRecyclerViewListener = clickListener
    }
    init {
        ButterKnife.bind(this, itemView)
        tripPackageContainer.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        aRecyclerViewListener.onClick(v, getAdapterPosition());
    }

    fun bind(aCategory: String, context: Context) {

        tripPackageTitleTextView.setText(aCategory);



    }
}
