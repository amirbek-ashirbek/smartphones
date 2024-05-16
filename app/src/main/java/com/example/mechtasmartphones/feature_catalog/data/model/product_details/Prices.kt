package com.example.mechtasmartphones.feature_catalog.data.model.product_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Prices(
    @Json(name = "base_price")
    val basePrice: Int?,
    @Json(name = "discounted_price")
    val discountedPrice: Int?,
    @Json(name = "has_discount")
    val hasDiscount: Boolean?
)