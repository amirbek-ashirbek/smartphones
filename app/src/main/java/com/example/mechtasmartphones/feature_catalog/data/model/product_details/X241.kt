package com.example.mechtasmartphones.feature_catalog.data.model.product_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class X241(
    @Json(name = "prop_group_name")
    val propGroupName: String?,
    @Json(name = "prop_group_sort")
    val propGroupSort: Int?,
    @Json(name = "values")
    val values: List<Value?>?
)