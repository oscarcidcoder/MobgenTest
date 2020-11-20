package com.mobgen.mobgentest.ui.detail

import android.view.View
import com.mobgen.mobgentest.domain.House
import com.mobgen.mobgentest.utils.loadUrl
import kotlinx.android.synthetic.main.item_detail_house.view.*

class HouseHolder(itemView: View) : DetailsAdapter.BaseViewHolder<House>(itemView){

    override fun bind(item: House) {
        itemView.apply {
            // Avoid repeat image
            iv_thumbnail.setImageResource(android.R.drawable.ic_menu_report_image)

            tv_house_name.text = tv_house_name.text.toString() + item.name
            tv_house_region.text = tv_house_region.text.toString() + item.region
            tv_house_title.text = tv_house_title.text.toString() + item.title

            item.houseType?.let {
                iv_thumbnail.loadUrl(it.imageUrl)
            }
            /*if (item.houseType != null){
                item.houseType!!.imageUrl.let {
                    iv_thumbnail.loadUrl(it)
                }
            }*/
        }
    }

}