package com.example.mechtasmartphones.feature_catalog.domain.use_case

import com.example.mechtasmartphones.core.Response
import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductItem
import com.example.mechtasmartphones.feature_catalog.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
	private val productRepository: ProductRepository
){

	suspend operator fun invoke(
		section: String,
		page: Int?,
		pageLimit: Int?
	): Response<List<ProductItem>> {
		return productRepository.getProducts(
			section = section,
			page = page,
			pageLimit = pageLimit
		)
	}

}