package com.example.mechtasmartphones.feature_catalog.data.model.product_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Голубой(
    @Json(name = "checked")
    val checked: Boolean?,
    @Json(name = "code")
    val code: String?,
    @Json(name = "hex_code")
    val hexCode: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "link")
    val link: String?,
    @Json(name = "value")
    val value: String?
)