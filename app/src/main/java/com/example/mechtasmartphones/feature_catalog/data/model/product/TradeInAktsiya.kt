package com.example.mechtasmartphones.feature_catalog.data.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TradeInAktsiya(
    @Json(name = "code")
    val code: String?,
    @Json(name = "color")
    val color: String?,
    @Json(name = "link")
    val link: String?,
    @Json(name = "name")
    val name: String?
)