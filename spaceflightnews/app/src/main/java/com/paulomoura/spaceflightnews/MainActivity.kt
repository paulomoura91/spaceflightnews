package com.paulomoura.spaceflightnews

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.paulomoura.dependencyinjection.core.DIActivity
import com.paulomoura.spaceflightnews.ui.theme.SpaceFlightNewsTheme
import com.paulomoura.spaceflightnews.view.articles.ShowArticleScreen

class MainActivity : DIActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceFlightNewsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ShowArticleScreen()
                }
            }
        }
    }
}
