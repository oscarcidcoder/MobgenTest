package com.mobgen.mobgentest.domain

import com.google.gson.annotations.SerializedName

data class Book (
	@SerializedName("name") val name : String,
	@SerializedName("isbn") val isbn : String,
	@SerializedName("authors") val authors : List<String>,
	@SerializedName("numberOfPages") val numberOfPages : Int,
	@SerializedName("publisher") val publisher : String,
	@SerializedName("country") val country : String,
	@SerializedName("mediaType") val mediaType : String,
	@SerializedName("released") val released : String
)