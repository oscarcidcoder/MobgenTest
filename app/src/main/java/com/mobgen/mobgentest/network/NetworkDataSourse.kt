package com.mobgen.mobgentest.network

class NetworkDataSourse(private val api: Api) : BaseDataSource() {

    suspend fun getCategories() = resolveResponse { api.getAllCategories() }

    suspend fun getBooks() = resolveResponse { api.getBooks() }

    suspend fun getHouses() = resolveResponse { api.getHouses() }

    suspend fun getCharacters() = resolveResponse { api.getCharacters() }

}