package com.mobgen.mobgentest.network.dto

import com.google.gson.annotations.SerializedName
import com.mobgen.mobgentest.domain.Category

data class CategoryDTO (
	@SerializedName("category_name") val categoryName : String,
	@SerializedName("type") val type : Int
)

fun CategoryDTO.asDomain() = Category(this.categoryName, this.type)

fun List<CategoryDTO>.asDomain() = this.map { it.asDomain() }