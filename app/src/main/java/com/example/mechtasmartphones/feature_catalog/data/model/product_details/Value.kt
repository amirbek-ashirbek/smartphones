package com.example.mechtasmartphones.feature_catalog.data.model.product_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Value(
    @Json(name = "code")
    val code: String?,
    @Json(name = "prop_id")
    val propId: Int?,
    @Json(name = "prop_name")
    val propName: String?,
    @Json(name = "prop_name_description")
    val propNameDescription: String?,
    @Json(name = "prop_name_id")
    val propNameId: Int?,
    @Json(name = "prop_value")
    val propValue: String?,
    @Json(name = "prop_xml_id")
    val propXmlId: String?,
    @Json(name = "section")
    val section: Any?
)