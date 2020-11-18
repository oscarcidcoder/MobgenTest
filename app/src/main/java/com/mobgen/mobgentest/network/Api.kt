package com.mobgen.mobgentest.network

import com.mobgen.mobgentest.network.dto.*
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("/categories")
    suspend fun getAllCategories(): Response<List<CategoryDTO>>

    @GET("list/1")
    suspend fun getBooks(): Response<List<BookDTO>>

    @GET("list/2")
    suspend fun getHouses(): Response<List<HouseDTO>>

    @GET("list/3")
    suspend fun getCharacters(): Response<List<CharacterDTO>>

}