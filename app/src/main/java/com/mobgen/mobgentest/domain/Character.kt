package com.mobgen.mobgentest.domain

data class Character (
	val id : Int,
	val name : String,
	val gender : String,
	val culture : String,
	val born : String,
	val died : String,
	val titles : List<String>,
	val aliases : List<String>,
	val father : String,
	val mother : String,
	val spouse : String,
	val allegiances : List<String>,
	val playedBy : List<String>
)