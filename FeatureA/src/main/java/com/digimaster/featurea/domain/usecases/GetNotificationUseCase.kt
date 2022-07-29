package com.digimaster.featurea.domain.usecases

import com.digimaster.featurea.domain.models.NotificationModel
import com.digimaster.featurea.domain.repositories.MainRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetNotificationUseCase @Inject constructor(private val mainRepository: MainRepository) {
    fun execute(): Flowable<List<NotificationModel>> =
        mainRepository.loadNotification()
}