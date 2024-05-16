package com.example.mechtasmartphones.feature_catalog.data.model.product_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Metrics(
    @Json(name = "brand")
    val brand: String?,
    @Json(name = "category")
    val category: String?,
    @Json(name = "name")
    val name: String?
)