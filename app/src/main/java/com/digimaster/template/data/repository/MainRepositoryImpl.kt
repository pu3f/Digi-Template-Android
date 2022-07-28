package com.digimaster.template.data.repository

import com.digimaster.template.data.remote.MainRemoteDataSource
import com.digimaster.template.model.NewsResponse
import io.reactivex.Single
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val mainRemoteDataSource: MainRemoteDataSource): MainRepository{
    override fun getNews(): Single<NewsResponse> {
        return mainRemoteDataSource.getNews()
    }
}