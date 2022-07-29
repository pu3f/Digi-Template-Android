package com.digimaster.featurea.domain.models

data class NewsDetailModel(
    val categoryNewsName: String,
    val createdAt: String,
    val newsDescription: String,
    val newsId: Int,
    val newsImage: String,
    val newsName: String
)