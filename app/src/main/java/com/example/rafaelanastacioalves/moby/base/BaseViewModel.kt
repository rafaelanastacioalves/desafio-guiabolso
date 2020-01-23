package com.example.rafaelanastacioalves.moby.base

import android.arch.lifecycle.ViewModel
import com.example.rafaelanastacioalves.moby.jokeshowing.JokeShowingViewModel
import com.example.rafaelanastacioalves.moby.categorylisting.LiveDataMainEntityListViewModel
import com.example.rafaelanastacioalves.moby.injection.component.DaggerViewModelInjector
import com.example.rafaelanastacioalves.moby.injection.component.ViewModelInjector
import com.example.rafaelanastacioalves.moby.injection.module.NetworkModule

abstract class BaseViewModel: ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is JokeShowingViewModel -> injector.inject(this)
            is LiveDataMainEntityListViewModel -> injector.inject(this)
        }
    }
}