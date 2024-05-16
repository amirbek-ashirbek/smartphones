package com.example.mechtasmartphones.feature_catalog.domain.use_case

import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductItem
import com.example.mechtasmartphones.feature_catalog.domain.repository.ProductRepository
import javax.inject.Inject

class ToggleFavouriteUseCase @Inject constructor(
	private val productRepository: ProductRepository
) {
	suspend operator fun invoke(product: ProductItem): Boolean {
		val isFavourite = product.isFavourite
		return if (isFavourite) {
			productRepository.deleteProductFromFavorites(productId = product.id)
			false
		} else {
			productRepository.addProductToFavorites(product)
			true
		}
	}
}