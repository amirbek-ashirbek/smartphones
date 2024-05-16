package com.example.mechtasmartphones.feature_catalog.data.model.product_details


import com.example.mechtasmartphones.feature_catalog.data.model.product_details.MainPropertyResponse.Companion.toMainProperty
import com.example.mechtasmartphones.feature_catalog.domain.model.product_details.ProductDetails
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductDetailsResponse(
    @Json(name = "data")
    val `data`: Data?,
    @Json(name = "errors")
    val errors: List<Any>?,
    @Json(name = "result")
    val result: Boolean?
) {

    companion object {
        fun toProductDetails(response: ProductDetailsResponse): ProductDetails {
            return ProductDetails(
                name = response.data?.name.orEmpty(),
                price = response.data?.price ?: 0,
                imageUrls = response.data?.photos ?: emptyList(),
                mainProperties = response.data?.mainProperties?.map { propertyResponse ->
                    toMainProperty(propertyResponse)
                } ?: emptyList(),
                isFavourite = false,
                code = response.data?.code.orEmpty()
            )
        }
    }

}