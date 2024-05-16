package com.example.mechtasmartphones.feature_catalog.data.remote

import com.example.mechtasmartphones.feature_catalog.data.model.product.ProductsResponse
import com.example.mechtasmartphones.feature_catalog.data.model.product_details.ProductDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CatalogApi {

	@GET("catalog")
	suspend fun getProducts(
		@Query("page") page: Int? = 1,
		@Query("page_limit") pageLimit: Int? = 30,
		@Query("section") section: String
	): ProductsResponse

	@GET("product/{productCode}")
	suspend fun getProductDetails(
		@Path("productCode") productCode: String
	): ProductDetailsResponse

}