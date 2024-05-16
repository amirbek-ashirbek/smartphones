package com.example.mechtasmartphones.feature_catalog.data.model.product_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class City(
    @Json(name = "days")
    val days: String?,
    @Json(name = "info")
    val info: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "price")
    val price: String?,
    @Json(name = "text")
    val text: String?
)