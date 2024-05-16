package com.example.mechtasmartphones.feature_catalog.data.model.product_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MetaTags(
    @Json(name = "description")
    val description: String?,
    @Json(name = "keywords")
    val keywords: String?,
    @Json(name = "og:description")
    val ogDescription: String?,
    @Json(name = "og:image")
    val ogImage: String?,
    @Json(name = "og:image:height")
    val ogImageHeight: String?,
    @Json(name = "og:image:width")
    val ogImageWidth: String?,
    @Json(name = "og:site_name")
    val ogSiteName: String?,
    @Json(name = "og:title")
    val ogTitle: String?,
    @Json(name = "og:type")
    val ogType: String?,
    @Json(name = "title")
    val title: String?
)