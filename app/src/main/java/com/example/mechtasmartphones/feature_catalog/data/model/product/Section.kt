package com.example.mechtasmartphones.feature_catalog.data.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Section(
    @Json(name = "code")
    val code: String?,
    @Json(name = "name")
    val name: String?
)