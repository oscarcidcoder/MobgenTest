package com.mobgen.mobgentest.di

import com.mobgen.mobgentest.repository.RepositoryMobgen
import org.koin.dsl.module

val repositoryModule = module {
    single { RepositoryMobgen(remote = get(), local = get()) }
}