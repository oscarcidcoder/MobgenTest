package com.mobgen.mobgentest

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MobgenApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MobgenApp)
        }
    }
}