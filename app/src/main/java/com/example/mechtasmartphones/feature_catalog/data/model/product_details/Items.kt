package com.example.mechtasmartphones.feature_catalog.data.model.product_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Items(
    @Json(name = "белый")
    val белый: Белый?,
    @Json(name = "голубой")
    val голубой: Голубой?
)