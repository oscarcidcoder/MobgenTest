package com.mobgen.mobgentest.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mobgen.mobgentest.domain.Category

@Entity(tableName = "category")
data class CategoryDB(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                      val name : String,
                      val type : Int)

fun CategoryDB.asDomain() = Category(this.name,this.type)

fun List<CategoryDB>.asDomain() = this.map { it.asDomain() }