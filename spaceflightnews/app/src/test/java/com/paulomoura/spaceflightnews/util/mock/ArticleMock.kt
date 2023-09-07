package com.paulomoura.spaceflightnews.util.mock

import com.paulomoura.spaceflightnews.model.dto.articles.Article
import com.paulomoura.spaceflightnews.model.dto.articles.Event
import com.paulomoura.spaceflightnews.model.dto.articles.Launch

val articleMock = Article(
    id = 20688,
    title = "Coverage Set as NASA’s SpaceX Crew-6 Prepares for Splashdown",
    url = "http://www.nasa.gov/press-release/coverage-set-as-nasa-s-spacex-crew-6-prepares-for-splashdown",
    imageUrl = "https://www.nasa.gov/sites/default/files/thumbnails/image/52870842128_42b3c12152_k_0.jpg?itok=seuIuNb4",
    newsSite = "NASA",
    summary = "NASA will provide coverage of the agency’s SpaceX Crew-6 mission return to Earth from the International Space Station",
    publishedAt = "2023-09-02T18:06:00Z",
    updatedAt = "2023-09-02T18:20:56.894000Z",
    featured = false,
    launches = listOf(
        Launch(launchId = "bc325945-4bee-4412-84e1-14998b2eba5f", provider = "Launch Library 2")
    ),
    events = listOf(
        Event(eventId = 771, provider = "Launch Library 2"),
        Event(eventId = 772, provider = "Launch Library 2")
    )
)