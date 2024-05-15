package com.example.mechtasmartphones.feature_catalog.data.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
	@Json(name = "all_items_count")
    val allItemsCount: Int?,
	@Json(name = "breadcrumbs")
    val breadcrumbs: List<Breadcrumb?>?,
	@Json(name = "header")
    val header: String?,
	@Json(name = "index")
    val index: Boolean?,
	@Json(name = "items")
    val items: List<ProductItem?>?,
	@Json(name = "meta_tags")
    val metaTags: MetaTags?,
	@Json(name = "page_items_count")
    val pageItemsCount: Int?,
	@Json(name = "page_number")
    val pageNumber: Int?,
	@Json(name = "section_1c_code")
    val section1cCode: String?,
	@Json(name = "section_description")
    val sectionDescription: String?,
	@Json(name = "section_id")
    val sectionId: Int?,
	@Json(name = "section_list")
    val sectionList: List<Section?>?
)