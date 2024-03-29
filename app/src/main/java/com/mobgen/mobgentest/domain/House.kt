package com.mobgen.mobgentest.domain

data class House (
	val id : Int,
	val name : String,
	val region : String,
	val title : String
) {
	val houseType: HouseType?
		get() = HouseType.byRegion(this.region)

}