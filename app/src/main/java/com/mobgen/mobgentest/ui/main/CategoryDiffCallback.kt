package com.mobgen.mobgentest.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.mobgen.mobgentest.domain.Category

class CategoryDiffCallback : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.name.equals(newItem.name,true)
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category) = oldItem == newItem

}