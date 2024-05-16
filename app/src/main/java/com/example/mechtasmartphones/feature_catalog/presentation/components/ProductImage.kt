package com.example.mechtasmartphones.feature_catalog.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.mechtasmartphones.core.presentation.components.CustomLoadingIndicator
import com.example.mechtasmartphones.feature_catalog.presentation.util.Constants

@Composable
fun ProductImage(
	url: String,
	modifier: Modifier = Modifier
) {
	SubcomposeAsyncImage(
		model = ImageRequest
			.Builder(LocalContext.current)
			.data(url)
			.crossfade(durationMillis = Constants.PRODUCT_ITEM_CROSSFADE_ANIMATION_DURATION_IN_MILLIS)
			.build(),
		contentDescription = null,
		loading = {
			CustomLoadingIndicator()
		},
		modifier = modifier
	)
}