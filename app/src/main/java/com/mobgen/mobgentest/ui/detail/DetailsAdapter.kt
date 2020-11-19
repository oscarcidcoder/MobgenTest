package com.mobgen.mobgentest.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobgen.mobgentest.R
import com.mobgen.mobgentest.domain.Book
import com.mobgen.mobgentest.domain.Category
import com.mobgen.mobgentest.domain.Character
import com.mobgen.mobgentest.domain.House

class DetailsAdapter(private val category: Category) : RecyclerView.Adapter<DetailsAdapter.BaseViewHolder<*>>() {

    private var detailList: MutableList<Any> = mutableListOf()

    fun submitData(newDatails: List<Any>) {
        detailList.clear()
        detailList.addAll(newDatails)
        notifyDataSetChanged()
    }

    abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: T)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (category.type) {
            0 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail_book, parent, false)
                BookHolder(view)
            }
            1 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail_house, parent, false)
                HouseHolder(view)
            }
            2 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail_character, parent, false)
                CharacterHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        detailList.get(position).also {
            when(holder){
                is BookHolder -> holder.bind(it as Book)
                is HouseHolder -> holder.bind(it as House)
                is CharacterHolder -> holder.bind(it as Character)
                else -> throw IllegalArgumentException()
            }
        }
    }

    override fun getItemCount() = detailList.size

}

