package com.mobgen.mobgentest.ui.detail

import android.view.View
import com.mobgen.mobgentest.domain.Book
import com.mobgen.mobgentest.utils.bulletList
import kotlinx.android.synthetic.main.item_detail_book.view.*

class BookHolder(itemView: View) : DetailsAdapter.BaseViewHolder<Book>(itemView){

    override fun bind(item: Book) {
        itemView.apply {
            tv_book_name.text = item.name
            tv_isbn.text = item.isbn
            tv_pages.text = item.numberOfPages.toString()
            tv_mediaType.text = item.mediaType
            tv_released.text = item.released
            tv_country.text = item.country
            tv_publisher.text = item.publisher
            tv_autors.text = item.authors.bulletList()
        }
    }

}