package com.paulomoura.spaceflightnews.model.dto.articles

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Article(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "url")
    val url: String? = null,
    @Json(name = "image_url")
    val imageUrl: String? = null,
    @Json(name = "news_site")
    val newsSite: String? = null,
    @Json(name = "summary")
    val summary: String? = null,
    @Json(name = "published_at")
    val publishedAt: String? = null,
    @Json(name = "updated_at")
    val updatedAt: String? = null,
    @Json(name = "featured")
    val featured: Boolean? = null,
    @Json(name = "launches")
    val launches: List<Launch>? = null,
    @Json(name = "events")
    val events: List<Event>? = null,
)

@JsonClass(generateAdapter = true)
data class Launch(
    @Json(name = "launch_id")
    val launchId: String? = null,
    @Json(name = "provider")
    val provider: String? = null,
)

@JsonClass(generateAdapter = true)
data class Event(
    @Json(name = "event_id")
    val eventId: Int? = null,
    @Json(name = "provider")
    val provider: String? = null,
)