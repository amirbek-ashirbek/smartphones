package com.example.mechtasmartphones.feature_catalog.data.model.product_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SameProducts(
    @Json(name = "5911")
    val x5911: X5911?,
    @Json(name = "5961")
    val x5961: X5961?
)