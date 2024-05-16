package com.example.mechtasmartphones.feature_catalog.domain.use_case

import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductItem
import com.example.mechtasmartphones.feature_catalog.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveFavouriteProductsUseCase @Inject constructor(
	private val productRepository: ProductRepository
) {
	operator fun invoke(): Flow<List<ProductItem>> {
		return productRepository.getFavoriteProducts()
	}
}