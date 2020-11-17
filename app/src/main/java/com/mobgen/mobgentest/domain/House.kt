package com.mobgen.mobgentest.domain

import com.google.gson.annotations.SerializedName

data class House (
	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("region") val region : String,
	@SerializedName("title") val title : String
)