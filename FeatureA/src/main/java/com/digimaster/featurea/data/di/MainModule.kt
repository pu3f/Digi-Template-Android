package com.digimaster.featurea.data.di

import com.digimaster.digicore.room.NotificationDao
import com.digimaster.featurea.data.remote.MainRemoteDataSource
import com.digimaster.featurea.data.remote.MainRemoteDataSourceImpl
import com.digimaster.featurea.data.repository.MainRepository
import com.digimaster.featurea.data.repository.MainRepositoryImpl
import com.digimaster.featurea.data.service.MainRetrofit
import com.digimaster.featurea.data.service.MainService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    @Singleton
    fun provideMainRepository(
        mainRemoteDataSource: MainRemoteDataSource,
        notificationDao: NotificationDao
    )
            : MainRepository =
        MainRepositoryImpl(mainRemoteDataSource, notificationDao)

    @Provides
    @Singleton
    fun provideMainRemoteDataSource(mainService: MainService): MainRemoteDataSource =
        MainRemoteDataSourceImpl(mainService)

    @Provides
    @Singleton
    fun provideMainService(): MainService = MainRetrofit.mainService
}