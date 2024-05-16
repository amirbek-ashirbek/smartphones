package com.example.mechtasmartphones.feature_catalog.presentation.product_details_screen

import com.example.mechtasmartphones.feature_catalog.domain.model.product_details.ProductDetails

//data class ProductDetailsState(
//	val productDetails: ProductDetails = ProductDetails(),
//	val errorMessage: String? = null,
//	val isLoading: Boolean = false
//)

sealed class ProductDetailsState {
	data object Loading : ProductDetailsState()
	data class Success(val data: ProductDetails) : ProductDetailsState()
	data class Error(val errorMessage: String) : ProductDetailsState()
}