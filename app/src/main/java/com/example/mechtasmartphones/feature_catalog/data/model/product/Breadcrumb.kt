package com.example.mechtasmartphones.feature_catalog.data.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Breadcrumb(
    @Json(name = "code")
    val code: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "name_ru")
    val nameRu: String?
)