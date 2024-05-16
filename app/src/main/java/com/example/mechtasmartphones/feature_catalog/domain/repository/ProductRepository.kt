package com.example.mechtasmartphones.feature_catalog.domain.repository

import com.example.mechtasmartphones.core.Response
import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductItem
import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductsData
import com.example.mechtasmartphones.feature_catalog.domain.model.product_details.ProductDetails
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

	suspend fun getProducts(
		section: String,
		page: Int?,
		pageLimit: Int?
	): Response<ProductsData>

	fun getProductDetails(
		productCode: String
	): Flow<Response<ProductDetails>>

	suspend fun addProductToFavorites(product: ProductItem)

	suspend fun deleteProductFromFavorites(productId: Int)

	fun getFavoriteProducts(): Flow<List<ProductItem>>

}