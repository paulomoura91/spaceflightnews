package com.paulomoura.spaceflightnews.model.apiservice

import com.paulomoura.spaceflightnews.model.apiservice.articles.ArticlesApiService
import io.kotest.matchers.types.shouldBeInstanceOf
import org.junit.Test

class ApiServiceBuilderTest {

    @Test
    fun `Check if getApiService is providing a correct instance of ArticlesApiService`() {
        // When
        val apiService = apiService<ArticlesApiService>()

        // Then
        apiService.shouldBeInstanceOf<ArticlesApiService>()
    }
}