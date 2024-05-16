package com.example.mechtasmartphones.feature_catalog.presentation

import com.example.mechtasmartphones.core.Response
import com.example.mechtasmartphones.core.presentation.pagination.Paginator
import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductsData
import javax.inject.Inject

class ProductsPaginator<Key, Item> @Inject constructor(
	private val initialKey: Key,
	private inline val onLoadingUpdated: (Boolean) -> Unit,
	private inline val onRequest: suspend (nextKey: Key) -> Response<ProductsData>,
	private inline val getNextKey: suspend (ProductsData) -> Key,
	private inline val onError: (Response<*>) -> Unit,
	private inline val onSuccess: (ProductsData, Key) -> Unit
) : Paginator<Key, Item> {

	private var currentKey: Key = initialKey
	private var isMakingRequest = false

	override suspend fun loadNextItems() {

		if (isMakingRequest) return

		isMakingRequest = true
		onLoadingUpdated(true)

		val response = onRequest(currentKey)

		when (response) {
			is Response.Success -> {
				val newKey = getNextKey(response.value)
				onSuccess(response.value, newKey)
				updateCurrentKey(newKey)
			}
			is Response.GenericError -> {
				onError(response)
			}
			is Response.NetworkError -> {
				onError(response)
			}
		}
		onLoadingUpdated(false)
		isMakingRequest = false
	}

	fun updateCurrentKey(newKey: Key) {
		currentKey = newKey
	}

	override fun reset() {
		currentKey = initialKey
	}

}