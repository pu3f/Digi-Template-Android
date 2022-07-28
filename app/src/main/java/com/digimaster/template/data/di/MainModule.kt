package com.digimaster.template.data.di

import com.digimaster.template.data.remote.MainRemoteDataSource
import com.digimaster.template.data.remote.MainRemoteDataSourceImpl
import com.digimaster.template.data.repository.MainRepository
import com.digimaster.template.data.repository.MainRepositoryImpl
import com.digimaster.template.data.service.MainRetrofit
import com.digimaster.template.data.service.MainService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainModule {

    @Provides
    @Singleton
    fun provideMainRepository(mainRemoteDataSource: MainRemoteDataSource): MainRepository =
        MainRepositoryImpl(mainRemoteDataSource)

    @Provides
    @Singleton
    fun provideMainRemoteDataSource(mainService: MainService): MainRemoteDataSource =
        MainRemoteDataSourceImpl(mainService)

    @Provides
    @Singleton
    fun provideMainService(): MainService = MainRetrofit.mainService
}