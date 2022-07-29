package com.digimaster.featurea.data.service

import com.digimaster.featurea.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object MainRetrofit {
    const val BASE_URL = BuildConfig.BASE_URL

    val retrofitClient: Retrofit.Builder by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(logging).readTimeout(120, TimeUnit.SECONDS).connectTimeout(
            120,
            TimeUnit.SECONDS
        ).addInterceptor(logging).build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val mainService: MainService by lazy {
        retrofitClient
            .build()
            .create(MainService::class.java)
    }
}