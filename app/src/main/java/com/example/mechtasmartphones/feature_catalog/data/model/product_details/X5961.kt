package com.example.mechtasmartphones.feature_catalog.data.model.product_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class X5961(
    @Json(name = "items")
    val items: ItemsX?,
    @Json(name = "name")
    val name: String?
)