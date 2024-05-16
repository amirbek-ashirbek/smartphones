package com.example.mechtasmartphones.feature_catalog.data.model.product_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Shop(
    @Json(name = "coordinates")
    val coordinates: Coordinates?,
    @Json(name = "items_count")
    val itemsCount: Double?,
    @Json(name = "items_count_real")
    val itemsCountReal: Int?,
    @Json(name = "shop_name")
    val shopName: String?,
    @Json(name = "work_time")
    val workTime: String?,
    @Json(name = "work_time_short")
    val workTimeShort: String?
)