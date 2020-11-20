package com.mobgen.mobgentest.ui.detail

import android.view.View
import com.mobgen.mobgentest.R
import com.mobgen.mobgentest.domain.Book
import com.mobgen.mobgentest.utils.bulletList
import kotlinx.android.synthetic.main.item_detail_book.view.*
import java.text.SimpleDateFormat
import java.util.*

class BookHolder(itemView: View) : DetailsAdapter.BaseViewHolder<Book>(itemView){

    override fun bind(item: Book) {
        itemView.apply {
            tv_book_name.text = context.getString(R.string.label_name).plus(item.name)
            tv_isbn.text = context.getString(R.string.label_isbn).plus(item.isbn)
            tv_pages.text = context.getString(R.string.label_pages).plus(item.numberOfPages.toString())
            tv_mediaType.text = context.getString(R.string.label_mediaType).plus(item.mediaType)
            tv_released.text = context.getString(R.string.label_released).plus(parseDate(item.released))
            tv_country.text = context.getString(R.string.label_country).plus(item.country)
            tv_publisher.text = context.getString(R.string.label_publisher).plus(item.publisher)
            tv_authors.text = context.getString(R.string.label_authors).plus(item.authors.bulletList())
        }
    }

    private fun parseDate(dateString: String): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return formatter.parse(dateString).let {
            formatter.format(it!!)
        }
    }

}