package com.digimaster.featurea.data.service

import com.digimaster.featurea.data.models.NewsResponseModel
import io.reactivex.Single
import retrofit2.http.GET

interface MainService {
    @GET("/api/v1/dashboard/news/home")
    fun getNews(): Single<NewsResponseModel>
}