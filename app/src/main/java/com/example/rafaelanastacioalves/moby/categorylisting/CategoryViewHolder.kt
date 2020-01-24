package com.example.rafaelanastacioalves.moby.categorylisting;

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.rafaelanastacioalves.moby.R
import com.example.rafaelanastacioalves.moby.listeners.RecyclerViewClickListener

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    @BindView(R.id.joke_category_container)
    lateinit var jokeCategoryContainer: View
    lateinit private var aRecyclerViewListener: RecyclerViewClickListener

    @BindView(R.id.joke_category_title_textview)
    lateinit var jokeCategoryTitleTextView: TextView;

    constructor(itemView: View , clickListener: RecyclerViewClickListener) : this(itemView) {
        this.aRecyclerViewListener = clickListener
    }
    init {
        ButterKnife.bind(this, itemView)
        jokeCategoryContainer.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        aRecyclerViewListener.onClick(v, getAdapterPosition());
    }

    fun bind(aCategory: String, context: Context) {

        jokeCategoryTitleTextView.setText(aCategory);



    }
}
