package com.mobgen.mobgentest.repository

import com.mobgen.mobgentest.db.dao.CategoryDAO
import com.mobgen.mobgentest.db.model.asDomain
import com.mobgen.mobgentest.domain.Category
import com.mobgen.mobgentest.domain.asDB
import com.mobgen.mobgentest.network.NetworkDataSourse
import com.mobgen.mobgentest.network.dto.asDomain
import com.mobgen.mobgentest.utils.Result
import com.mobgen.mobgentest.utils.convertIfSuccess

class RepositoryMobgen(private val remote: NetworkDataSourse, private val local: CategoryDAO) {

    suspend fun getCategories(): Result<List<Category>> {
        val localCategies = local.getCategories()
        if (localCategies.isEmpty()) {
            return remote.getCategories().convertIfSuccess {
                val categoriesDomain = it.asDomain().sortedBy { it.name }
                local.insertCategories(categoriesDomain.asDB())
                categoriesDomain
            }
        }
        return Result.Success(localCategies.asDomain().sortedBy { it.name })
    }

    suspend fun getBooks() = remote.getBooks().convertIfSuccess { it.asDomain() }

    suspend fun getHouses() = remote.getHouses().convertIfSuccess { it.asDomain() }

    suspend fun getCharacters() = remote.getCharacters().convertIfSuccess { it.asDomain() }

}