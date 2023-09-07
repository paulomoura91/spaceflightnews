package com.paulomoura.spaceflightnews.view.articles

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.paulomoura.spaceflightnews.model.dto.articles.Article
import com.paulomoura.spaceflightnews.presentation.UIState
import com.paulomoura.spaceflightnews.ui.composable.Text
import com.paulomoura.spaceflightnews.viewmodel.articles.ArticlesViewModel
import kotlinx.coroutines.flow.StateFlow

@Composable
fun ShowArticleScreen(articleStateFlow: StateFlow<UIState<Article>> = viewModel<ArticlesViewModel>().articleStateFlow) {
    val articleState by articleStateFlow.collectAsState()
    when (articleState) {
        is UIState.Loading -> ShowLoading()
        is UIState.Success -> ShowSuccess(article = articleState.data ?: Article())
        is UIState.Error -> ShowError()
    }
}

@Composable
fun ShowLoading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(modifier = Modifier.testTag("ArticleLoading"))
    }
}

@Composable
fun ShowSuccess(article: Article) {
    Column(modifier = Modifier.padding(all = 16.dp)) {
        Text(
            text = article.newsSite,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.testTag("ArticleNewsSiteText"),
        )
        Spacer(modifier = Modifier.height(height = 16.dp))
        Text(
            text = article.title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.testTag("ArticleTitleText"),
        )
        Spacer(modifier = Modifier.height(height = 16.dp))
        Text(
            text = article.url,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.testTag("ArticleUrlText"),
        )
    }
}

@Composable
fun ShowError() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Error!", modifier = Modifier.testTag("ArticleErrorText"))
    }
}