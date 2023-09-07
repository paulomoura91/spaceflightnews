package com.paulomoura.spaceflightnews.model.repository.articles

import com.paulomoura.spaceflightnews.model.apiservice.apiService
import com.paulomoura.spaceflightnews.model.apiservice.articles.ArticlesApiService
import com.paulomoura.spaceflightnews.model.dto.articles.Article

class ArticlesRepository(private val articlesApiService: ArticlesApiService = apiService()) {

    suspend fun getArticle(id: Int): Article = articlesApiService.getArticle(id = id)
}