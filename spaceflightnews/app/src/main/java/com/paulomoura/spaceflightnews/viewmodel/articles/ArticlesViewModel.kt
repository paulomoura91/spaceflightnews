package com.paulomoura.spaceflightnews.viewmodel.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulomoura.spaceflightnews.model.dto.articles.Article
import com.paulomoura.spaceflightnews.model.repository.articles.ArticlesRepository
import com.paulomoura.spaceflightnews.presentation.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(private val articlesRepository: ArticlesRepository = ArticlesRepository()) : ViewModel() {

    private val _articleStateFlow = MutableStateFlow<UIState<Article>>(UIState.Loading())
    val articleStateFlow = _articleStateFlow.asStateFlow()

    init {
        viewModelScope.launch {
            runCatching { articlesRepository.getArticle(id = (1..100).random()) }
                .onSuccess { article -> _articleStateFlow.value = UIState.Success(successData = article) }
                .onFailure { _articleStateFlow.value = UIState.Error() }
        }
    }
}