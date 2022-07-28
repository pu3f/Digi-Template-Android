package com.digimaster.template.data.repository

import com.digimaster.template.model.NewsResponse
import io.reactivex.Single

interface MainRepository {
    fun getNews(): Single<NewsResponse>
}