package com.digimaster.featurea.data.remote

import com.digimaster.featurea.model.NewsResponse
import io.reactivex.Single

interface MainRemoteDataSource {
    fun getNews(): Single<NewsResponse>
}