package com.mobgen.mobgentest.di

import androidx.room.Room
import com.mobgen.mobgentest.db.MobgenDB
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    // Database build
    single {
        Room.databaseBuilder(androidApplication(),MobgenDB::class.java,"MobgenDB")
            .fallbackToDestructiveMigration()
            .build()
    }

    // DAO build
    single {
        get<MobgenDB>().categoryDAO
    }

}