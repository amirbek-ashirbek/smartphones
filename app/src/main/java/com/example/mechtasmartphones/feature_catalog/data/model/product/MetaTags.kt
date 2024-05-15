package com.example.mechtasmartphones.feature_catalog.data.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MetaTags(
    @Json(name = "canonical")
    val canonical: Any?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "keywords")
    val keywords: String?,
    @Json(name = "noindex")
    val noindex: Any?,
    @Json(name = "og:image")
    val ogImage: String?,
    @Json(name = "og:image:height")
    val ogImageHeight: String?,
    @Json(name = "og:image:width")
    val ogImageWidth: String?,
    @Json(name = "og:title")
    val ogTitle: String?,
    @Json(name = "og:type")
    val ogType: String?,
    @Json(name = "title")
    val title: String?
)