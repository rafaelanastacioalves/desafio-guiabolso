package com.example.rafaelanastacioalves.moby.categorylisting;

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.rafaelanastacioalves.moby.R
import com.example.rafaelanastacioalves.moby.listeners.RecyclerViewClickListener
import kotlinx.android.synthetic.main.detail_entity_viewholder.view.joke_category_container

class CategoryViewHolder(itemView: View) : LayoutContainer, RecyclerView.ViewHolder(itemView), View.OnClickListener{


    lateinit private var aRecyclerViewListener: RecyclerViewClickListener


    constructor(itemView: View , clickListener: RecyclerViewClickListener) : this(itemView) {
        this.aRecyclerViewListener = clickListener
    }
    init {
        ButterKnife.bind(this, itemView)
        joke.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        aRecyclerViewListener.onClick(v, getAdapterPosition());
    }

    fun bind(aCategory: String, context: Context) {

        joke_category_title_textview.setText(aCategory);



    }
}
