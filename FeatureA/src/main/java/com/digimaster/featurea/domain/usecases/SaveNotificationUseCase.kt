package com.digimaster.featurea.domain.usecases

import com.digimaster.featurea.domain.models.NotificationModel
import com.digimaster.featurea.domain.repositories.MainRepository
import io.reactivex.Single
import javax.inject.Inject

class SaveNotificationUseCase @Inject constructor(private val mainRepository: MainRepository){
    fun save(notification: NotificationModel): Single<Long> {
        return mainRepository.insertNotification(notification)
    }
}