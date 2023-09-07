package com.paulomoura.spaceflightnews.util

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class MockServer {

    private val mockWebServer = MockWebServer()

    val headers get() = mockWebServer.takeRequest().headers
    val method get() = mockWebServer.takeRequest().method
    val path get() = mockWebServer.takeRequest().path
    val body get() = mockWebServer.takeRequest().body

    fun <T> create(service: Class<T>): T {
        mockWebServer.start(8080)

        val okHttpClient = OkHttpClient
            .Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        val moshiFactory = Moshi.Builder().build()

        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshiFactory))
            .build()
        return retrofit.create(service)
    }

    fun setResponse(responseCode: Int, responseJson: String = "") {
        mockWebServer.enqueue(
            MockResponse().setResponseCode(responseCode).setBody(responseJson)
        )
    }

    fun shutDown() = mockWebServer.shutdown()
}