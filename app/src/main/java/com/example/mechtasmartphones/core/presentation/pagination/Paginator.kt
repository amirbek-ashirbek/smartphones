package com.example.mechtasmartphones.core.presentation.pagination

interface Paginator<Key, Item> {
	suspend fun loadNextItems()
	fun reset()
}