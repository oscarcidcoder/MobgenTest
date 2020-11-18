package com.mobgen.mobgentest.network.dto

import com.google.gson.annotations.SerializedName
import com.mobgen.mobgentest.domain.House

data class HouseDTO (
	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("region") val region : String,
	@SerializedName("title") val title : String
)

fun HouseDTO.asDomain() =
	House(this.id,
		this.name,
		this.region,
		this.title)

fun List<HouseDTO>.asDomain() = this.map { it.asDomain() }