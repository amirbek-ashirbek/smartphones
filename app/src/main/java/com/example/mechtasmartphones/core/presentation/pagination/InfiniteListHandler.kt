package com.example.mechtasmartphones.core.presentation.pagination

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun InfiniteListHandler(
	lazyGridState: LazyGridState,
	buffer: Int = 2,
	onLoadMore: () -> Unit
) {
	val loadMore = remember {
		derivedStateOf {
			val layoutInfo = lazyGridState.layoutInfo
			val totalItems = layoutInfo.totalItemsCount
			val lastVisibleItemIndex = (layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0) + 1
			totalItems > 0 && lastVisibleItemIndex > (totalItems - buffer)
		}
	}


	LaunchedEffect(loadMore) {
		snapshotFlow { loadMore.value }
			.distinctUntilChanged()
			.collect { loadMore ->
				if (loadMore) {
					onLoadMore()
				}
			}
	}
}