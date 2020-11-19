package com.mobgen.mobgentest.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.mobgen.mobgentest.R
import com.mobgen.mobgentest.domain.Category

class CategoryAdapter(private val listener: CategoryClickListener) : ListAdapter<Category, CategoryViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        getItem(position).also {category ->
            holder.bind(category)
            holder.itemView.setOnClickListener { listener.onCategoryClick(category,position) }
        }
    }

}

/**
 * Interface to propagate click events
 */
interface CategoryClickListener {
    fun onCategoryClick(category: Category, position: Int)
}