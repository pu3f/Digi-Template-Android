package com.digimaster.featurea.data.mappers

import com.digimaster.digicore.room.Notification
import com.digimaster.featurea.data.models.NewsDataModel
import com.digimaster.featurea.data.models.NewsResponseModel
import com.digimaster.featurea.domain.models.NewsDetailModel
import com.digimaster.featurea.domain.models.NewsModel
import com.digimaster.featurea.domain.models.NotificationModel

class DataMapper {

    fun toNewsModel(newsResponseModel: NewsResponseModel): NewsModel =
        NewsModel(newsResponseModel.code, newsResponseModel.newsDataModelList.map { toNewsDetailModel(it) },
            newsResponseModel.status)

    private fun toNewsDetailModel(newsDataModel: NewsDataModel): NewsDetailModel =
        NewsDetailModel(
            newsDataModel.categoryNewsName, newsDataModel.createdAt, newsDataModel.newsDescription,
            newsDataModel.newsId, newsDataModel.newsImage, newsDataModel.newsName
        )

    private fun toNotificationModel(notification: Notification): NotificationModel =
        NotificationModel(notification.title, notification.content)

    fun toNotificationModels(notifications: List<Notification>): List<NotificationModel> =
        notifications.map {
            toNotificationModel(it)
        }.toList()
}