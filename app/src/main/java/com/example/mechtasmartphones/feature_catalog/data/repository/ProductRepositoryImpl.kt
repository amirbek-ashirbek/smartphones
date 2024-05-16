package com.example.mechtasmartphones.feature_catalog.data.repository

import com.example.mechtasmartphones.core.Response
import com.example.mechtasmartphones.core.data.util.NetworkUtil
import com.example.mechtasmartphones.feature_catalog.data.local.ProductDao
import com.example.mechtasmartphones.feature_catalog.data.local.ProductEntity
import com.example.mechtasmartphones.feature_catalog.data.local.ProductEntity.Companion.toProductEntity
import com.example.mechtasmartphones.feature_catalog.data.model.product.ProductItemResponse
import com.example.mechtasmartphones.feature_catalog.data.model.product.ProductItemResponse.Companion.toProductItem
import com.example.mechtasmartphones.feature_catalog.data.model.product_details.ProductDetailsResponse.Companion.toProductDetails
import com.example.mechtasmartphones.feature_catalog.data.remote.CatalogApi
import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductItem
import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductsData
import com.example.mechtasmartphones.feature_catalog.domain.model.product_details.ProductDetails
import com.example.mechtasmartphones.feature_catalog.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
	private val catalogApi: CatalogApi,
	private val networkUtil: NetworkUtil,
	private val productDao: ProductDao
) : ProductRepository {

	override suspend fun getProducts(
		section: String,
		page: Int?,
		pageLimit: Int?
	): Response<ProductsData> {
		return networkUtil.safeApiCall {

			val favouriteProducts = productDao.getFavoriteProducts()
			val favouriteProductsIds = favouriteProducts.map { it.id }.toSet()

			catalogApi.getProducts(
				page = page,
				pageLimit = pageLimit,
				section = section
			).data?.let { data ->

				val products = data.items?.map { productResponse ->
					val productItem = toProductItem(productResponse)
					productItem.copy(
						isFavourite = productItem.id in favouriteProductsIds
					)
				} ?: emptyList()

				ProductsData(
					items = products,
					totalItemCount = data.allItemsCount ?: 0
				)
			} ?: ProductsData(items = emptyList(), totalItemCount = 0)
		}
	}

	override fun getProductDetails(productCode: String): Flow<Response<ProductDetails>> {
		return networkUtil.safeApiCallFlow {
			catalogApi.getProductDetails(productCode = productCode)
		}.map { response ->
			when (response) {
				is Response.GenericError -> response
				is Response.NetworkError -> response
				is Response.Success -> {
					val productDetailsResponse = response.value
					val productDetails = toProductDetails(productDetailsResponse)
					Response.Success(productDetails)
				}
			}
		}
	}

	override suspend fun addProductToFavorites(product: ProductItem) {
		productDao.addProductToFavorites(toProductEntity(product))
	}

	override suspend fun deleteProductFromFavorites(productId: Int) {
		productDao.deleteProductFromFavorites(productId)
	}

	override suspend fun getFavoriteProducts(): List<ProductItem> {
		return productDao.getFavoriteProducts().map { ProductEntity.toProductItem(it) }
	}

}