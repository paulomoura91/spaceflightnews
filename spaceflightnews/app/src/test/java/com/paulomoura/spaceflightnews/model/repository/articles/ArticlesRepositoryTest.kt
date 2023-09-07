package com.paulomoura.spaceflightnews.model.repository.articles

import com.paulomoura.spaceflightnews.model.apiservice.articles.ArticlesApiService
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class ArticlesRepositoryTest {

    private val articlesApiService: ArticlesApiService = mockk(relaxed = true)

    @Test
    fun `getArticle calls ArticlesApiService`() = runTest {
        // When
        val articlesRepository = ArticlesRepository(articlesApiService)
        articlesRepository.getArticle(0)

        // Then
        coVerify(exactly = 1) { articlesApiService.getArticle(any()) }
    }
}