package com.mobgen.mobgentest.di

import com.mobgen.mobgentest.ui.splash.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { SplashViewModel(get()) }

}