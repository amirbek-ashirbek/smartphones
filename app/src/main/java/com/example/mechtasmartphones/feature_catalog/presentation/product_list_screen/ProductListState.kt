package com.example.mechtasmartphones.feature_catalog.presentation.product_list_screen

import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductItem

data class ProductListState(
	val products: List<ProductItem> = emptyList(),
	val productsPage: Int = 1,
	val productsAreLoading: Boolean = false,
	val productsEndReached: Boolean = false,
	val productsErrorMessage: String? = null,
	val productsTotalCount: Int = 0
)
