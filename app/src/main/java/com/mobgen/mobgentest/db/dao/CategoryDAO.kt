package com.mobgen.mobgentest.db.dao

import androidx.room.*
import com.mobgen.mobgentest.db.model.CategoryDB

@Dao
interface CategoryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categoryDB: CategoryDB)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<CategoryDB>)

    @Query("SELECT * FROM category")
    suspend fun getCategories(): List<CategoryDB>

    @Query("SELECT * FROM category WHERE id = :categoryID")
    suspend fun getCategory(categoryID: Int): CategoryDB?

    @Query("DELETE FROM category")
    suspend fun deleteCategories()

    @Delete
    suspend fun deleteCategory(category: CategoryDB)

}