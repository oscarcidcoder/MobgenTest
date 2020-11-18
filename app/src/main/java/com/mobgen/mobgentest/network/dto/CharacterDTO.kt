package com.mobgen.mobgentest.network.dto

import com.google.gson.annotations.SerializedName
import com.mobgen.mobgentest.domain.Character

data class CharacterDTO (
	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("gender") val gender : String,
	@SerializedName("culture") val culture : String,
	@SerializedName("born") val born : String,
	@SerializedName("died") val died : String,
	@SerializedName("titles") val titles : List<String>,
	@SerializedName("aliases") val aliases : List<String>,
	@SerializedName("father") val father : String,
	@SerializedName("mother") val mother : String,
	@SerializedName("spouse") val spouse : Int,
	@SerializedName("allegiances") val allegiances : List<String>,
	@SerializedName("playedBy") val playedBy : List<String>
)

fun CharacterDTO.asDomain() =
	Character(this.id,
		this.name,
		this.gender,
		this.culture,
		this.born,
		this.died,
		this.titles,
		this.aliases,
		this.father,
		this.mother,
		this.spouse,
		this.allegiances,
		this.playedBy)

fun List<CharacterDTO>.asDomain() = this.map { it.asDomain() }