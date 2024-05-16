package com.example.mechtasmartphones.feature_catalog.presentation.product_details_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mechtasmartphones.R
import com.example.mechtasmartphones.core.presentation.components.CustomLoadingIndicator
import com.example.mechtasmartphones.core.presentation.components.CustomTopAppBar
import com.example.mechtasmartphones.core.presentation.components.TryAgainError
import com.example.mechtasmartphones.feature_catalog.presentation.components.ProductImage
import com.example.mechtasmartphones.feature_catalog.presentation.product_details_screen.components.ProductMainProperties

@Composable
fun ProductDetailsScreen(
	onBackClicked: () -> Unit
) {
	val viewModel: ProductDetailsViewModel = hiltViewModel()

	ProductDetailsScreenContent(
		uiState = viewModel.uiState.collectAsStateWithLifecycle().value,
		onEvent = viewModel::onEvent,
		onBackClicked = onBackClicked
	)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsScreenContent(
	uiState: ProductDetailsState,
	onEvent: (ProductDetailsEvent) -> Unit,
	onBackClicked: () -> Unit
) {

	val scrollState = rememberScrollState()

	Scaffold(
		topBar = {
			CustomTopAppBar(
				onBackClicked = onBackClicked,
				actionIcon = Icons.Default.FavoriteBorder,
				onActionIconClicked = { onEvent(ProductDetailsEvent.FavouriteClicked) },
				colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
					containerColor = MaterialTheme.colorScheme.background
				)
			)
		}
	) {
		Surface(
			color = MaterialTheme.colorScheme.background,
			modifier = Modifier
				.fillMaxSize()
				.padding(it)
		) {
			when (uiState) {
				is ProductDetailsState.Loading -> {
					CustomLoadingIndicator()
				}
				is ProductDetailsState.Error -> {
					TryAgainError(
						errorMessage = uiState.errorMessage,
						onTryAgainClicked = { onEvent(ProductDetailsEvent.TryAgainClicked) }
					)
				}
				is ProductDetailsState.Success -> {
					Column(
						modifier = Modifier
							.fillMaxWidth()
							.padding(horizontal = 16.dp)
							.verticalScroll(scrollState)
					) {
						ProductImage(
							url = uiState.data.imageUrls.first(),
							modifier = Modifier
								.align(Alignment.CenterHorizontally)
						)
						Spacer(modifier = Modifier.height(24.dp))
						ProductDetailsName(name = uiState.data.name)
						Spacer(modifier = Modifier.height(24.dp))
						ProductDetailsPriceText(price = uiState.data.price)
						Spacer(modifier = Modifier.height(40.dp))
						ProductMainProperties(properties = uiState.data.mainProperties)
						Spacer(modifier = Modifier.height(24.dp))
					}
				}
			}
		}
	}

}

@Composable
private fun ProductDetailsName(
	name: String
) {
	Text(
		text = name,
		style = MaterialTheme.typography.bodyLarge
	)
}

@Composable
private fun ProductDetailsPriceText(
	price: Int
) {
	Text(
		text = stringResource(id = R.string.product_price, price),
		style = MaterialTheme.typography.titleMedium.copy(
			fontSize = 20.sp
		)
	)
}