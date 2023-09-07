package com.paulomoura.spaceflightnews.model.apiservice.articles

import com.paulomoura.spaceflightnews.model.dto.articles.Article
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticlesApiService {

    @GET("articles/{id}")
    suspend fun getArticle(@Path("id") id: Int): Article
}