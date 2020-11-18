package com.mobgen.mobgentest.di

import com.mobgen.mobgentest.R
import com.mobgen.mobgentest.network.Api
import com.mobgen.mobgentest.network.NetworkDataSourse
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECTION_TIMEOUT = 15L
private const val READ_TIMEOUT = 20L

val networkModule = module {

    single {
        OkHttpClient.Builder().apply {
            connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
        }.build()
    }

    single {
        val apiURL = androidContext().getString(R.string.API_URL)
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(apiURL)

            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(Api::class.java) }
    single { NetworkDataSourse(api = get()) }

}