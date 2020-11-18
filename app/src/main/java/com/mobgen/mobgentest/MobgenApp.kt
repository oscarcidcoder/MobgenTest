package com.mobgen.mobgentest

import android.app.Application
import com.mobgen.mobgentest.di.databaseModule
import com.mobgen.mobgentest.di.networkModule
import com.mobgen.mobgentest.di.repositoryModule
import com.mobgen.mobgentest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MobgenApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MobgenApp)
            modules(networkModule)
            modules(databaseModule)
            modules(repositoryModule)
            modules(viewModelModule)
        }
    }
}