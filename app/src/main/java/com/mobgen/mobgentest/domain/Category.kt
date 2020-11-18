package com.mobgen.mobgentest.domain

import com.mobgen.mobgentest.db.model.CategoryDB

data class Category (
	val name : String,
	val type : Int
)

fun Category.asDB() = CategoryDB(name = this.name,type = this.type)

fun List<Category>.asDB() = this.map { it.asDB() }