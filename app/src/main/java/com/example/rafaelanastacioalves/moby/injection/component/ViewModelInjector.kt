package com.example.rafaelanastacioalves.moby.injection.component

import com.example.rafaelanastacioalves.moby.categorylisting.CategoryListingViewModel
import com.example.rafaelanastacioalves.moby.injection.module.NetworkModule
import com.example.rafaelanastacioalves.moby.jokeshowing.JokeShowingViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(mainEntityListViewModel: CategoryListingViewModel)
    fun inject(entityDetailsViewModel: JokeShowingViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}