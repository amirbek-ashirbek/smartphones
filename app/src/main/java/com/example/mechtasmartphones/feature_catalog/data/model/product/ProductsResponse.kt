package com.example.mechtasmartphones.feature_catalog.data.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductsResponse(
	@Json(name = "data")
    val `data`: Data?,
	@Json(name = "errors")
    val errors: List<Any?>?,
	@Json(name = "result")
    val result: Boolean?
)