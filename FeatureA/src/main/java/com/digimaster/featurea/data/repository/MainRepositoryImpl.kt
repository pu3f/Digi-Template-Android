package com.digimaster.featurea.data.repository

import com.digimaster.digicore.room.Notification
import com.digimaster.digicore.room.NotificationDao
import com.digimaster.featurea.data.mappers.DataMapper
import com.digimaster.featurea.data.service.MainService
import com.digimaster.featurea.domain.models.NewsModel
import com.digimaster.featurea.domain.models.NotificationModel
import com.digimaster.featurea.domain.repositories.MainRepository
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainService: MainService,
    private val notificationDao: NotificationDao,
    private val dataMapper: DataMapper
) : MainRepository {

    override fun getNews(): Single<NewsModel> {
        return mainService.getNews().map {
            dataMapper.toNewsModel(it)
        }
    }

    override fun loadNotification(): Flowable<List<NotificationModel>> {
        return notificationDao.getAll().map {
            dataMapper.toNotificationModels(it)
        }
    }

    override fun insertNotification(notification: NotificationModel): Single<Long> {
        return notificationDao.insertNotification(Notification(title = notification.title,
            content = notification.content))
    }
}