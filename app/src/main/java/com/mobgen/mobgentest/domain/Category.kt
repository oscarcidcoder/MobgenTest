package com.mobgen.mobgentest.domain

import com.google.gson.annotations.SerializedName

data class Category (
	@SerializedName("category_name") val category_name : String,
	@SerializedName("type") val type : Int
)