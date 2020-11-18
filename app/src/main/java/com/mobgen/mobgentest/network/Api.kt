package com.mobgen.mobgentest.network

import com.mobgen.mobgentest.domain.Book
import com.mobgen.mobgentest.domain.Category
import com.mobgen.mobgentest.domain.Character
import com.mobgen.mobgentest.domain.House
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("/categories")
    suspend fun getAllCategories(): Response<List<Category>>

    @GET("list/1")
    suspend fun getBooks(): Response<List<Book>>

    @GET("list/2")
    suspend fun getHouses(): Response<List<House>>

    @GET("list/3")
    suspend fun getCharacters(): Response<List<Character>>

}