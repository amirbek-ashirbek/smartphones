package com.example.mechtasmartphones.feature_catalog.domain.model.product_details

data class ProductDetails(
	val name: String = "",
	val price: Int = 0,
	val imageUrls: List<String> = emptyList(),
	val mainProperties: List<MainProperty> = emptyList(),
	val isFavourite: Boolean = false
)
