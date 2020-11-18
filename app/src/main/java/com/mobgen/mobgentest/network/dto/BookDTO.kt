package com.mobgen.mobgentest.network.dto

import com.google.gson.annotations.SerializedName
import com.mobgen.mobgentest.domain.Book

data class BookDTO (
	@SerializedName("name") val name : String,
	@SerializedName("isbn") val isbn : String,
	@SerializedName("authors") val authors : List<String>,
	@SerializedName("numberOfPages") val numberOfPages : Int,
	@SerializedName("publisher") val publisher : String,
	@SerializedName("country") val country : String,
	@SerializedName("mediaType") val mediaType : String,
	@SerializedName("released") val released : String
)

fun BookDTO.asDomain() =
	Book(this.name,
		this.isbn,
		this.authors,
		this.numberOfPages,
		this.publisher,
		this.country,
		this.mediaType,
		this.released)

fun List<BookDTO>.asDomain() = this.map { it.asDomain() }

