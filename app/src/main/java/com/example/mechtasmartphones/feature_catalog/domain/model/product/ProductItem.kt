package com.example.mechtasmartphones.feature_catalog.domain.model.product

data class ProductItem(
	val id: Int,
	val name: String,
	val price: Int,
	val imageUrls: List<String>
)
