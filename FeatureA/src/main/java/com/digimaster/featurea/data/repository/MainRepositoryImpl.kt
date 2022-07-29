package com.digimaster.featurea.data.repository

import com.digimaster.digicore.room.Notification
import com.digimaster.digicore.room.NotificationDao
import com.digimaster.featurea.data.remote.MainRemoteDataSource
import com.digimaster.featurea.model.NewsResponse
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainRemoteDataSource: MainRemoteDataSource,
    private val notificationDao: NotificationDao
) : MainRepository {
    override fun getNews(): Single<NewsResponse> {
        return mainRemoteDataSource.getNews()
    }

    override fun loadNotification(): Flowable<List<Notification>> {
        return notificationDao.getAll()
    }

    override fun insertNotification(notification: Notification): Single<Long> {
        return notificationDao.insertNotification(notification)
    }
}