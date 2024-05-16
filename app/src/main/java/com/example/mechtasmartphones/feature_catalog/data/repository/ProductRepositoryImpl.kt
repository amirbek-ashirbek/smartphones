package com.example.mechtasmartphones.feature_catalog.data.repository

import com.example.mechtasmartphones.core.Response
import com.example.mechtasmartphones.core.data.util.NetworkUtil
import com.example.mechtasmartphones.feature_catalog.data.model.product.ProductItemResponse
import com.example.mechtasmartphones.feature_catalog.data.remote.CatalogApi
import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductsData
import com.example.mechtasmartphones.feature_catalog.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
	private val catalogApi: CatalogApi,
	private val networkUtil: NetworkUtil
) : ProductRepository {

	override suspend fun getProducts(
		section: String,
		page: Int?,
		pageLimit: Int?
	): Response<ProductsData> {
		return networkUtil.safeApiCall {
			catalogApi.getProducts(
				page = page,
				pageLimit = pageLimit,
				section = section
			).data?.let { data ->
				ProductsData(
					items = data.items?.map(ProductItemResponse::toProductItem) ?: emptyList(),
					totalItemCount = data.allItemsCount ?: 0
				)
			} ?: ProductsData(items = emptyList(), totalItemCount = 0)
		}
	}

}