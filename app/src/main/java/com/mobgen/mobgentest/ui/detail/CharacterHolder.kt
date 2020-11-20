package com.mobgen.mobgentest.ui.detail

import android.view.View
import com.mobgen.mobgentest.domain.Character
import com.mobgen.mobgentest.utils.bulletList
import kotlinx.android.synthetic.main.item_detail_character.view.*

class CharacterHolder(itemView: View) : DetailsAdapter.BaseViewHolder<Character>(itemView){

    override fun bind(item: Character) {
        itemView.apply {
            tv_character_name.text = tv_character_name.text.toString() + item.name
            tv_character_gender.text = tv_character_gender.text.toString() + item.gender
            tv_character_culture.text = tv_character_culture.text.toString() + item.culture
            tv_character_born.text = tv_character_born.text.toString() + item.born
            tv_character_died.text = tv_character_died.text .toString() + item.died
            tv_character_aliases.text = tv_character_aliases.text .toString() + item.aliases.bulletList()
            tv_character_played_by.text = tv_character_played_by.text.toString() + item.playedBy.bulletList()
            tv_character_title.text = tv_character_title.text.toString() + item.titles.bulletList()
        }
    }

}