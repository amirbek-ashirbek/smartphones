package com.example.mechtasmartphones.feature_catalog.domain.model.product_details

data class ProductDetails(
	val id: Int = 0,
	val name: String = "",
	val price: Int = 0,
	val imageUrls: List<String> = emptyList(),
	val code: String,
	val isFavourite: Boolean = false,
	val mainProperties: List<MainProperty> = emptyList(),
)
