package com.mobgen.mobgentest.domain

data class Book (
	val name : String,
	val isbn : String,
	val authors : List<String>,
	val numberOfPages : Int,
	val publisher : String,
	val country : String,
	val mediaType : String,
	val released : String
)