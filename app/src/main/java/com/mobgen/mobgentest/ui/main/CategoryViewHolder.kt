package com.mobgen.mobgentest.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mobgen.mobgentest.R
import com.mobgen.mobgentest.domain.Category
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(category: Category) {
        itemView.apply {
            tv_category_name.text = category.name
            val imageResource = when (category.type) {
                0 ->  R.drawable.ic_book
                1 -> R.drawable.ic_house
                2 -> R.drawable.ic_character
                else -> R.drawable.ic_book
            }
            iv_thumbnail.setImageResource(imageResource)
        }
    }

}