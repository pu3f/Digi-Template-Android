package com.digimaster.featurea.domain.repositories

import com.digimaster.featurea.domain.models.NewsModel
import com.digimaster.featurea.domain.models.NotificationModel
import io.reactivex.Flowable
import io.reactivex.Single

interface MainRepository {
    fun getNews(): Single<NewsModel>
    fun loadNotification(): Flowable<List<NotificationModel>>
    fun insertNotification(notification: NotificationModel): Single<Long>
}