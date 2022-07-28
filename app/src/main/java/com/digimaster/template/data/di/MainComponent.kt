package com.digimaster.template.data.di

import com.digimaster.template.ui.viewmodel.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class])
interface MainComponent {
    fun injectNews(mainViewModel: MainViewModel)
}