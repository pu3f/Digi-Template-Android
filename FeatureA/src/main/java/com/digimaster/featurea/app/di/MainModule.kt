package com.digimaster.featurea.app.di

import com.digimaster.digicore.room.NotificationDao
import com.digimaster.featurea.data.mappers.DataMapper
import com.digimaster.featurea.domain.repositories.MainRepository
import com.digimaster.featurea.data.repository.MainRepositoryImpl
import com.digimaster.featurea.data.service.MainRetrofit
import com.digimaster.featurea.data.service.MainService
import com.digimaster.featurea.domain.usecases.GetNewsUseCase
import com.digimaster.featurea.domain.usecases.GetNotificationUseCase
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
        mainService: MainService,
        notificationDao: NotificationDao,
        dataMapper: DataMapper
    )
            : MainRepository =
        MainRepositoryImpl(mainService, notificationDao, dataMapper)

    @Provides
    @Singleton
    fun provideMapper(): DataMapper = DataMapper()

    @Provides
    @Singleton
    fun provideMainService(): MainService = MainRetrofit.mainService
}