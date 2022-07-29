package com.digimaster.featurea.data.remote

import com.digimaster.featurea.data.service.MainService
import com.digimaster.featurea.model.NewsResponse
import io.reactivex.Single
import javax.inject.Inject

class MainRemoteDataSourceImpl @Inject constructor(private val mainService: MainService):
    MainRemoteDataSource {
    override fun getNews(): Single<NewsResponse> {
        return mainService.getNews()
    }
}