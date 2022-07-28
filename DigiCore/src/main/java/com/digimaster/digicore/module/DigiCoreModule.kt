package com.digimaster.digicore.module

import android.content.Context
import androidx.room.Room
import com.digimaster.digicore.room.NotificationDao
import com.digimaster.digicore.room.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DigiCoreModule {
    @Provides
    @Singleton
    fun provideNotificationDao(appDatabase: AppDatabase): NotificationDao =
        appDatabase.notificationDao()

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase =
        Room.databaseBuilder(appContext, AppDatabase::class.java, "templateDatabase").build()
}