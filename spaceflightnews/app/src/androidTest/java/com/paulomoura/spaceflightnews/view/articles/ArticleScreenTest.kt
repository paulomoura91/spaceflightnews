package com.paulomoura.spaceflightnews.view.articles

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.paulomoura.spaceflightnews.model.dto.articles.Article
import com.paulomoura.spaceflightnews.presentation.UIState
import com.paulomoura.spaceflightnews.ui.theme.SpaceFlightNewsTheme
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Rule
import org.junit.Test

class ArticleScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun articleScreenIsVisible_loadingState_showCircularProgressIndicator() {
        composeTestRule.setContent {
            SpaceFlightNewsTheme {
                ShowArticleScreen(articleStateFlow = MutableStateFlow(UIState.Loading()))
            }
        }
        composeTestRule
            .onNodeWithTag(testTag = "ArticleLoading")
            .assertIsDisplayed()
    }

    @Test
    fun articleScreenIsVisible_successState_showArticle() {
        composeTestRule.setContent {
            SpaceFlightNewsTheme {
                val article = Article(
                    newsSite = "NASA",
                    title = "NASA title",
                    url = "NASA url",
                )
                ShowArticleScreen(articleStateFlow = MutableStateFlow(UIState.Success(successData = article)))
            }
        }
        composeTestRule
            .onNodeWithTag(testTag = "ArticleNewsSiteText")
            .assertTextEquals("NASA")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithTag(testTag = "ArticleTitleText")
            .assertTextEquals("NASA title")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithTag(testTag = "ArticleUrlText")
            .assertTextEquals("NASA url")
            .assertIsDisplayed()
    }

    @Test
    fun articleScreenIsVisible_errorState_showErrorMessage() {
        composeTestRule.setContent {
            SpaceFlightNewsTheme {
                ShowArticleScreen(articleStateFlow = MutableStateFlow(UIState.Error()))
            }
        }
        composeTestRule
            .onNodeWithTag(testTag = "ArticleErrorText")
            .assertTextEquals("Error!")
            .assertIsDisplayed()
    }
}