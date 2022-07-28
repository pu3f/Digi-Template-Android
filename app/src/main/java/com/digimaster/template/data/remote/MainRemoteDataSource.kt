package com.digimaster.template.data.remote

import com.digimaster.template.model.NewsResponse
import io.reactivex.Single

interface MainRemoteDataSource {
    fun getNews(): Single<NewsResponse>
}