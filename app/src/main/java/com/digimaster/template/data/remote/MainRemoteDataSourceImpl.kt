package com.digimaster.template.data.remote

import com.digimaster.template.data.service.MainService
import com.digimaster.template.model.NewsResponse
import io.reactivex.Single
import javax.inject.Inject

class MainRemoteDataSourceImpl @Inject constructor(private val mainService: MainService): MainRemoteDataSource {
    override fun getNews(): Single<NewsResponse> {
        return mainService.getNews()
    }
}