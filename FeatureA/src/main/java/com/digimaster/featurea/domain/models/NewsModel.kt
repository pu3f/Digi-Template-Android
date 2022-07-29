package com.digimaster.featurea.domain.models

data class NewsModel(
    val code: Int,
    val newsDataModelList: List<NewsDetailModel>,
    val status: String
)
