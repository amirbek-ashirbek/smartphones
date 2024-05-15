package com.example.mechtasmartphones.core.presentation.pagination

import com.example.mechtasmartphones.core.Response
import javax.inject.Inject

class PaginatorImpl<Key, Item> @Inject constructor(
	private val initialKey: Key,
	private inline val onLoadingUpdated: (Boolean) -> Unit,
	private inline val onRequest: suspend (nextKey: Key) -> Response<List<Item>>,
	private inline val getNextKey: suspend (List<Item>) -> Key,
	private inline val onError: (Response<*>) -> Unit,
	private inline val onSuccess: (List<Item>, Key) -> Unit
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
				onError(response as Response<*>)
			}
			is Response.NetworkError -> {
				onError(response as Response<*>)
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