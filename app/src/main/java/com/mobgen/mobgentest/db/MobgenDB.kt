package com.mobgen.mobgentest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mobgen.mobgentest.db.dao.CategoryDAO
import com.mobgen.mobgentest.db.model.CategoryDB

@Database(
    entities = [CategoryDB::class],
    version = 1, exportSchema = false
)
abstract class MobgenDB :  RoomDatabase() {
    abstract val categoryDAO: CategoryDAO
}