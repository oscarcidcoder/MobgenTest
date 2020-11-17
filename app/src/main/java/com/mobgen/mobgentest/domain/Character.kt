package com.mobgen.mobgentest.domain

import com.google.gson.annotations.SerializedName

data class Character (
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