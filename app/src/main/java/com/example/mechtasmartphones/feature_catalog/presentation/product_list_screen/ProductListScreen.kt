package com.example.mechtasmartphones.feature_catalog.presentation.product_list_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mechtasmartphones.R
import com.example.mechtasmartphones.feature_catalog.presentation.product_list_screen.components.ProductGrid

@Composable
fun ProductListScreen(
	onNavigateToProductDetails: (String) -> Unit
) {
	val viewModel: ProductListViewModel = hiltViewModel()

	ProductListScreenContent(
		uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
		onEvent = viewModel::onEvent,
		onNavigateToProductDetails = onNavigateToProductDetails
	)
}

@Composable
fun ProductListScreenContent(
	uiState: ProductListState,
	onEvent: (ProductListEvent) -> Unit,
	onNavigateToProductDetails: (String) -> Unit
) {
	Surface(
		modifier = Modifier
			.fillMaxSize()
	) {
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 16.dp)
		) {
			Spacer(modifier = Modifier.height(32.dp))
			Text(
				text = stringResource(id = R.string.smartphones),
				style = MaterialTheme.typography.titleMedium
			)
			Spacer(modifier = Modifier.height(32.dp))
			ProductGrid(
				products = uiState.products,
				totalCount = uiState.productsTotalCount,
				isLoading = uiState.productsAreLoading,
				errorMessage = uiState.productsErrorMessage,
				noMoreItemsToLoad = uiState.productsEndReached,
				onUserScrolledToEnd = { onEvent(ProductListEvent.UserScrolledToListEnd) },
				onTryAgainClicked = { onEvent(ProductListEvent.TryAgainClicked) },
				onItemClicked = {  productCode ->
					onNavigateToProductDetails(productCode)
				}
			)
		}
	}
}

