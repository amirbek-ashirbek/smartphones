package com.example.mechtasmartphones.feature_catalog.domain.repository

import com.example.mechtasmartphones.core.Response
import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductItem

interface ProductRepository {

	suspend fun getProducts(
		section: String,
		page: Int?,
		pageLimit: Int?
	): Response<List<ProductItem>>

}