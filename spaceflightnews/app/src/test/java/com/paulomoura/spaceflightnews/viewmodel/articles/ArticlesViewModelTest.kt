package com.paulomoura.spaceflightnews.viewmodel.articles

import com.paulomoura.spaceflightnews.model.repository.articles.ArticlesRepository
import com.paulomoura.spaceflightnews.presentation.UIState
import com.paulomoura.spaceflightnews.util.MainDispatcherRule
import com.paulomoura.spaceflightnews.util.mock.articleMock
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class ArticlesViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val articlesRepository: ArticlesRepository = mockk()
    private lateinit var articlesViewModel: ArticlesViewModel

    @Test
    fun `Test getArticle success state`() = runTest {
        // Given
        coEvery { articlesRepository.getArticle(any()) } returns articleMock

        // When
        articlesViewModel = ArticlesViewModel(articlesRepository)

        // Then
        articlesViewModel.articleStateFlow.value.shouldBe(UIState.Success(articleMock))
    }

    @Test
    fun `Test getArticle error state`() = runTest {
        // Given
        coEvery { articlesRepository.getArticle(any()) } throws Exception()

        // When
        articlesViewModel = ArticlesViewModel(articlesRepository)

        // Then
        articlesViewModel.articleStateFlow.value.shouldBe(UIState.Error())
    }
}