package com.example.mechtasmartphones.feature_catalog.data.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Stickers(
	@Json(name = "delivery-express")
    val deliveryExpress: DeliveryExpress?,
	@Json(name = "trade-in-aktsiya")
    val tradeInAktsiya: TradeInAktsiya?
)