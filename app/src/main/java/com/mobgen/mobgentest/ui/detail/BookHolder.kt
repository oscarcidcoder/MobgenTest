package com.mobgen.mobgentest.ui.detail

import android.view.View
import com.mobgen.mobgentest.domain.Book
import com.mobgen.mobgentest.utils.bulletList
import kotlinx.android.synthetic.main.item_detail_book.view.*
import java.text.SimpleDateFormat
import java.util.*

class BookHolder(itemView: View) : DetailsAdapter.BaseViewHolder<Book>(itemView){

    override fun bind(item: Book) {
        itemView.apply {
            tv_book_name.text = tv_book_name.text.toString() + item.name
            tv_isbn.text = tv_isbn.text.toString() + item.isbn
            tv_pages.text = tv_pages.text.toString() + item.numberOfPages.toString()
            tv_mediaType.text = tv_mediaType.text.toString() + item.mediaType
            tv_released.text = tv_released.text.toString() + parseDate(item.released)
            tv_country.text = tv_country.text .toString() + item.country
            tv_publisher.text = tv_publisher.text.toString() + item.publisher
            tv_authors.text = tv_authors.text.toString() + item.authors.bulletList()
        }
    }

    private fun parseDate(dateString: String): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return formatter.parse(dateString).let {
            formatter.format(it!!)
        }
    }

}