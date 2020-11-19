package com.mobgen.mobgentest.ui.detail

import android.view.View
import com.mobgen.mobgentest.domain.Character
import com.mobgen.mobgentest.utils.bulletList
import kotlinx.android.synthetic.main.item_detail_character.view.*

class CharacterHolder(itemView: View) : DetailsAdapter.BaseViewHolder<Character>(itemView){

    override fun bind(item: Character) {
        itemView.apply {
            tv_character_name.text = item.name
            tv_character_gender.text = item.gender
            tv_character_culture.text = item.culture
            tv_character_born.text = item.born
            tv_character_died.text = item.died
            tv_character_aliases.text = item.aliases.bulletList()
            tv_character_played_by.text = item.playedBy.bulletList()
            tv_character_title.text = item.titles.bulletList()
        }
    }

}