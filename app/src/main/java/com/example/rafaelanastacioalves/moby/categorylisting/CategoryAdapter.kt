package com.example.rafaelanastacioalves.moby.categorylisting;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.rafaelanastacioalves.moby.R;
import com.example.rafaelanastacioalves.moby.listeners.RecyclerViewClickListener;

import kotlin.collections.ArrayList

class CategoryAdapter(context: Context) : RecyclerView.Adapter<CategoryViewHolder>() {
    lateinit private var recyclerViewClickListener: RecyclerViewClickListener
    private var items: List<String>? = null

    private val mContext: Context = context

    fun setRecyclerViewClickListener(aRVC: RecyclerViewClickListener ) {
        this.recyclerViewClickListener = aRVC;
    }

    fun getItems(): List<String>? {
        return this.items;
    }

    fun setItems(items: List<String>?) {
        this.items = items as ArrayList<String>;
        notifyDataSetChanged();
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder  {
        return CategoryViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detail_entity_viewholder, parent, false), recyclerViewClickListener);
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int ) {
        val aRepoW = getItems()?.get(position) as String;
        holder.bind(aRepoW, mContext);
    }


    override fun getItemCount(): Int {
        if (getItems() != null){
            return getItems()!!.size;
        }else{
            return 0;
        }
    }
}

