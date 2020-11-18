package com.mobgen.mobgentest.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class CategoryDB(@PrimaryKey(autoGenerate = true) val id: Int,
                      val category_name : String,
                      val type : Int)