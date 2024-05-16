package com.example.mechtasmartphones.feature_catalog.domain.use_case

import com.example.mechtasmartphones.core.Response
import com.example.mechtasmartphones.feature_catalog.domain.model.product_details.ProductDetails
import com.example.mechtasmartphones.feature_catalog.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductDetailsUseCase @Inject constructor(
	private val productRepository: ProductRepository
) {

	operator fun invoke(productCode: String): Flow<Response<ProductDetails>> {
		return productRepository.getProductDetails(productCode = productCode)
	}

}