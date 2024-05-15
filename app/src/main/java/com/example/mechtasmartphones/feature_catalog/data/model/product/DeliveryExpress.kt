package com.example.mechtasmartphones.feature_catalog.data.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DeliveryExpress(
    @Json(name = "color")
    val color: String?,
    @Json(name = "link")
    val link: Any?,
    @Json(name = "name")
    val name: String?
)