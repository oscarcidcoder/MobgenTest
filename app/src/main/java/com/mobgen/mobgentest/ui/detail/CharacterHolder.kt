package com.mobgen.mobgentest.ui.detail

import android.view.View
import com.mobgen.mobgentest.R
import com.mobgen.mobgentest.domain.Character
import com.mobgen.mobgentest.utils.bulletList
import kotlinx.android.synthetic.main.item_detail_character.view.*

class CharacterHolder(itemView: View) : DetailsAdapter.BaseViewHolder<Character>(itemView){

    override fun bind(item: Character) {
        itemView.apply {
            tv_character_name.text = context.getString(R.string.label_name).plus(item.name)
            tv_character_gender.text = context.getString(R.string.label_gender).plus(item.gender)
            tv_character_culture.text = context.getString(R.string.label_culture).plus(item.culture)
            tv_character_born.text = context.getString(R.string.label_born).plus(item.born)
            tv_character_died.text = context.getString(R.string.label_died).plus(item.died)
            tv_character_aliases.text = context.getString(R.string.label_alias).plus(item.aliases.bulletList())
            tv_character_played_by.text = context.getString(R.string.label_playedBy).plus(item.playedBy.bulletList())
            tv_character_title.text = context.getString(R.string.label_title).plus(item.titles.bulletList())
        }
    }

}