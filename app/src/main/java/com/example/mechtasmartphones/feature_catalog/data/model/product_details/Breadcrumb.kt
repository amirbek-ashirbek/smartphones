package com.example.mechtasmartphones.feature_catalog.data.model.product_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Breadcrumb(
    @Json(name = "code")
    val code: String?,
    @Json(name = "name")
    val name: String?
)