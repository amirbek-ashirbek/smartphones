package com.example.mechtasmartphones.feature_catalog.data.model.product_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Stream24(
    @Json(name = "brand")
    val brand: String?,
    @Json(name = "contentType")
    val contentType: String?,
    @Json(name = "el")
    val el: String?,
    @Json(name = "productId")
    val productId: String?,
    @Json(name = "resultType")
    val resultType: String?,
    @Json(name = "retailerDomain")
    val retailerDomain: String?,
    @Json(name = "templateType")
    val templateType: String?
)