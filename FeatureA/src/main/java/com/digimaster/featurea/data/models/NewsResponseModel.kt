package com.digimaster.featurea.data.models

import com.google.gson.annotations.SerializedName

data class NewsResponseModel(
    val code: Int,
    @SerializedName("data")
    val newsDataModelList: List<NewsDataModel>,
    val status: String
)