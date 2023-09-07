package com.paulomoura.spaceflightnews.model.apiservice.articles

import com.paulomoura.spaceflightnews.util.MockServer
import com.paulomoura.spaceflightnews.util.mock.articleMock
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class ArticlesApiServiceTest {

    private val mockServer = MockServer()
    private lateinit var articlesApiService: ArticlesApiService

    @Before
    fun `Setup ArticlesApiService`() {
        articlesApiService = mockServer.create(ArticlesApiService::class.java)
    }

    @Test
    fun `Check whether getArticle endpoint HTTP method is GET`() = runTest {
        // Given
        mockServer.setResponse(200, getArticleResponse)

        // When
        articlesApiService.getArticle(0)

        // Then
        mockServer.method.shouldBe("GET")
    }

    @Test
    fun `Check getArticle endpoint request path`() = runTest {
        // Given
        mockServer.setResponse(200, getArticleResponse)

        // When
        articlesApiService.getArticle(0)

        // Then
        mockServer.path.shouldBe("/articles/0")
    }

    @Test
    fun `Test success response of getArticle endpoint`() = runTest {
        // Given
        mockServer.setResponse(200, getArticleResponse)

        // When
        val response = articlesApiService.getArticle(0)

        // Then
        response.shouldBe(articleMock)
    }

    @Test
    fun `Test error response of getArticle endpoint`() {
        // Given
        mockServer.setResponse(404)

        // Then
        shouldThrowAny {
            // When
            runBlocking { articlesApiService.getArticle(0) }
        }
    }

    private val getArticleResponse =
        """
        {
            "id": 20688,
            "title": "Coverage Set as NASA’s SpaceX Crew-6 Prepares for Splashdown",
            "url": "http://www.nasa.gov/press-release/coverage-set-as-nasa-s-spacex-crew-6-prepares-for-splashdown",
            "image_url": "https://www.nasa.gov/sites/default/files/thumbnails/image/52870842128_42b3c12152_k_0.jpg?itok=seuIuNb4",
            "news_site": "NASA",
            "summary": "NASA will provide coverage of the agency’s SpaceX Crew-6 mission return to Earth from the International Space Station",
            "published_at": "2023-09-02T18:06:00Z",
            "updated_at": "2023-09-02T18:20:56.894000Z",
            "featured": false,
            "launches": [
                {
                    "launch_id": "bc325945-4bee-4412-84e1-14998b2eba5f",
                    "provider": "Launch Library 2"
                }
            ],
            "events": [
                {
                    "event_id": 771,
                    "provider": "Launch Library 2"
                },
                {
                    "event_id": 772,
                    "provider": "Launch Library 2"
                }
            ]
        }
        """

    @After
    fun `Shut mockServer down`() = mockServer.shutDown()
}