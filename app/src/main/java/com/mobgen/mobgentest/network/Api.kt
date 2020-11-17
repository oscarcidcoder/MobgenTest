package com.mobgen.mobgentest.network

import com.mobgen.mobgentest.domain.Book
import com.mobgen.mobgentest.domain.Category
import com.mobgen.mobgentest.domain.Character
import com.mobgen.mobgentest.domain.House
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("/categories")
    suspend fun getAllCategories(): Response<Result<List<Category>>>

    @GET("list/1")
    suspend fun getBooks(): Response<Result<List<Book>>>

    @GET("list/2")
    suspend fun getHouses(): Response<Result<List<House>>>

    @GET("list/3")
    suspend fun getCharacters(): Response<Result<List<Character>>>

}