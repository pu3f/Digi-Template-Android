package com.digimaster.template.data.service

import com.digimaster.template.model.NewsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface MainService {
    @GET("/api/v1/dashboard/news/home")
    fun getNews(): Single<NewsResponse>
}