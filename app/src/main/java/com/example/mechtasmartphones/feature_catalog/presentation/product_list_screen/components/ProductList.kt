package com.example.mechtasmartphones.feature_catalog.presentation.product_list_screen.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mechtasmartphones.core.presentation.pagination.InfiniteListHandler
import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductItem

@Composable
fun ProductList(
	products: List<ProductItem>,
	isLoading: Boolean,
	errorMessage: String?,
	noMoreItemsToLoad: Boolean,
	onUserScrolledToEnd: () -> Unit,
) {

	val listState = rememberLazyListState()

	LazyColumn(
		state = listState,
		modifier = Modifier
			.fillMaxSize()
	) {
		items(products, key = { product -> product.id }) { product ->
			ProductItem(
				name = product.name
			)
		}
	}

	InfiniteListHandler(
		lazyListState = listState,
		onLoadMore = {
			if (!noMoreItemsToLoad) {
				onUserScrolledToEnd()
			}
		}
	)

}