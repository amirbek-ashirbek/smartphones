package com.example.mechtasmartphones.feature_catalog.presentation.product_list_screen

sealed class ProductListEvent {
	data object UserScrolledToListEnd : ProductListEvent()
}