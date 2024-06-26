package com.example.mechtasmartphones.feature_catalog.data.model.product


import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductItem
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductItemResponse(
	@Json(name = "availability")
    val availability: String?,
	@Json(name = "bonus")
    val bonus: Int?,
	@Json(name = "city_code_for_kaspi")
    val cityCodeForKaspi: String?,
	@Json(name = "city_exist")
    val cityExist: Boolean?,
	@Json(name = "code")
    val code: String?,
	@Json(name = "code_1c")
    val code1c: String?,
	@Json(name = "digital")
    val digital: Boolean?,
	@Json(name = "express")
    val express: Boolean?,
	@Json(name = "express_delivery")
    val expressDelivery: Boolean?,
	@Json(name = "gifts")
    val gifts: List<Any?>?,
	@Json(name = "has_gift")
    val hasGift: Boolean?,
	@Json(name = "id")
    val id: Int?,
	@Json(name = "in_compare")
    val inCompare: Boolean?,
	@Json(name = "in_favorites")
    val inFavorites: Boolean?,
	@Json(name = "is_intercity")
    val isIntercity: Boolean?,
	@Json(name = "metrics")
    val metrics: Metrics?,
	@Json(name = "name")
    val name: String?,
	@Json(name = "new_item")
    val newItem: Boolean?,
	@Json(name = "photos")
    val photos: List<String>?,
	@Json(name = "pod_order_item")
    val podOrderItem: Boolean?,
	@Json(name = "pod_order_time")
    val podOrderTime: Any?,
	@Json(name = "preorder")
    val preorder: Boolean?,
	@Json(name = "preorder_link")
    val preorderLink: Any?,
	@Json(name = "preorder_start")
    val preorderStart: Any?,
	@Json(name = "preorder_sum")
    val preorderSum: Any?,
	@Json(name = "price")
    val price: Int?,
	@Json(name = "prices")
    val prices: Prices?,
	@Json(name = "rating")
    val rating: Double?,
	@Json(name = "reviews_count")
    val reviewsCount: Int?,
	@Json(name = "same_product_properties")
    val sameProductProperties: List<String?>?,
	@Json(name = "service")
    val service: Boolean?,
//	@Json(name = "stickers")
//    val stickers: Stickers?,
	@Json(name = "title")
    val title: String?,
	@Json(name = "type")
    val type: Int?,
	@Json(name = "video_link")
    val videoLink: List<String?>?,
	@Json(name = "xml_id")
    val xmlId: String?
) {
	companion object {
		fun toProductItem(response: ProductItemResponse): ProductItem {
			return ProductItem(
				id = response.id ?: 0,
				name = response.name.orEmpty(),
				price = response.price ?: 0,
				imageUrls = response.photos ?: emptyList(),
				code = response.code.orEmpty()
			)
		}
	}
}