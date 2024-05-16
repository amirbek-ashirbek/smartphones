package com.example.mechtasmartphones.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {

	@Serializable
	object ProductList

	@Serializable
	data class ProductDetails(
		val productCode: String,
		val isFavourite: Boolean
	)
}