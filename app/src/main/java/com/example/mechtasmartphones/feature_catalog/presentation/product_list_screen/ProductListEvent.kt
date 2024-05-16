package com.example.mechtasmartphones.feature_catalog.presentation.product_list_screen

import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductItem

sealed class ProductListEvent {
	data object UserScrolledToListEnd : ProductListEvent()
	data object TryAgainClicked : ProductListEvent()
	data class FavouriteToggled(val product: ProductItem) : ProductListEvent()
}