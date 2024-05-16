package com.example.mechtasmartphones.feature_catalog.presentation.product_details_screen

sealed class ProductDetailsEvent {
	data object TryAgainClicked : ProductDetailsEvent()
	data object FavouriteClicked : ProductDetailsEvent()
}
