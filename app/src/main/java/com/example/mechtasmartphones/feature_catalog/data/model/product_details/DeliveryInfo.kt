package com.example.mechtasmartphones.feature_catalog.data.model.product_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DeliveryInfo(
    @Json(name = "delivery")
    val delivery: Delivery?,
    @Json(name = "pickup")
    val pickup: Pickup?
)