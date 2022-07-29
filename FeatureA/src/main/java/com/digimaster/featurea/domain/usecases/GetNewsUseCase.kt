package com.digimaster.featurea.domain.usecases

import com.digimaster.digicore.base.SingleUseCase
import com.digimaster.featurea.domain.repositories.MainRepository
import com.digimaster.featurea.domain.models.NewsModel
import io.reactivex.Single
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val mainRepository: MainRepository): SingleUseCase<NewsModel> {
    override fun execute(): Single<NewsModel> {
        return mainRepository.getNews()
    }
}