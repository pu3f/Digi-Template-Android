package com.digimaster.template.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    val code: Int,
    @SerializedName("data")
    val newsDataList: List<NewsData>,
    val status: String
)