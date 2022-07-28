package com.digimaster.template.data.repository

import com.digimaster.digicore.room.Notification
import com.digimaster.template.model.NewsResponse
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface MainRepository {
    fun getNews(): Single<NewsResponse>
    fun loadNotification(): Flowable<List<Notification>>
    fun insertNotification(notification: Notification): Single<Long>
}