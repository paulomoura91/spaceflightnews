package com.paulomoura.dependencyinjection

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

private const val TAG_OKHTTP = "OkHttp"
private const val CONNECT_TIMEOUT = 60L
private const val READ_TIMEOUT = 60L
private const val BASE_URL = "https://api.spaceflightnewsapi.net/v4/"

private val logger: HttpLoggingInterceptor by lazy { HttpLoggingInterceptor { Log.d(TAG_OKHTTP, it) }.apply { level = HttpLoggingInterceptor.Level.BODY } }

private val okHttpClient: OkHttpClient by lazy {
    OkHttpClient()
        .newBuilder()
        .addInterceptor(logger)
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .build()
}

val RetrofitInstance: Retrofit by lazy {
    Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}