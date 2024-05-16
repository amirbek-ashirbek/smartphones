package com.example.mechtasmartphones.feature_catalog.presentation.product_list_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mechtasmartphones.R
import com.example.mechtasmartphones.core.presentation.pagination.InfiniteListHandler
import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductItem
import com.example.mechtasmartphones.feature_catalog.presentation.util.Constants.PRODUCTS_GRID_COLUMNS_COUNT

@Composable
fun ProductGrid(
	products: List<ProductItem>,
	totalCount: Int,
	isLoading: Boolean,
	errorMessage: String?,
	noMoreItemsToLoad: Boolean,
	onUserScrolledToEnd: () -> Unit,
) {

	val gridState = rememberLazyGridState()

	LazyVerticalGrid(
		state = gridState,
		columns = GridCells.Fixed(PRODUCTS_GRID_COLUMNS_COUNT),
		horizontalArrangement = Arrangement.spacedBy(10.dp),
		verticalArrangement = Arrangement.spacedBy(10.dp),
		modifier = Modifier
			.fillMaxSize()
	) {
		item(span = { GridItemSpan(PRODUCTS_GRID_COLUMNS_COUNT) }) {
			Column {
				ProductCountText(count = totalCount)
				Spacer(modifier = Modifier.height(16.dp))
			}
		}
		items(products, key = { product -> product.id }) { product ->
			ProductItem(
				name = product.name,
				imageUrl = product.imageUrls.first(),
				isFavourite = false,
				price = product.price
			)
		}
	}

	InfiniteListHandler(
		buffer = 10,
		lazyGridState = gridState,
		onLoadMore = {
			if (!noMoreItemsToLoad) {
				onUserScrolledToEnd()
			}
		}
	)

}

@Composable
private fun ProductCountText(
	count: Int
) {
	Text(
		text = stringResource(id = R.string.product_count, count),
		style = MaterialTheme.typography.titleMedium
	)
}