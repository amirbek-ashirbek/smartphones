package com.example.mechtasmartphones.feature_catalog.presentation.product_list_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mechtasmartphones.feature_catalog.presentation.product_list_screen.components.ProductList

@Composable
fun ProductListScreen(

) {
	val viewModel: ProductListViewModel = hiltViewModel()

	ProductListScreenContent(
		uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
		onEvent = viewModel::onEvent
	)
}

@Composable
fun ProductListScreenContent(
	uiState: ProductListState,
	onEvent: (ProductListEvent) -> Unit
) {
	Surface(
		modifier = Modifier
			.fillMaxSize()
	) {
		ProductList(
			products = uiState.products,
			isLoading = uiState.productsAreLoading,
			errorMessage = uiState.productsErrorMessage,
			noMoreItemsToLoad = uiState.productsEndReached,
			onUserScrolledToEnd = { onEvent(ProductListEvent.UserScrolledToListEnd) }
		)
	}
}