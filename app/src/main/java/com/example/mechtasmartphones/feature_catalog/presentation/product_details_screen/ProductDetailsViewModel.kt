package com.example.mechtasmartphones.feature_catalog.presentation.product_details_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.mechtasmartphones.R
import com.example.mechtasmartphones.core.Response
import com.example.mechtasmartphones.core.presentation.util.StringResourcesProvider
import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductItem
import com.example.mechtasmartphones.feature_catalog.domain.model.product_details.ProductDetails
import com.example.mechtasmartphones.feature_catalog.domain.use_case.GetProductDetailsUseCase
import com.example.mechtasmartphones.feature_catalog.domain.use_case.ToggleFavouriteUseCase
import com.example.mechtasmartphones.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
	private val getProductDetailsUseCase: GetProductDetailsUseCase,
	private val toggleFavouriteUseCase: ToggleFavouriteUseCase,
	private val stringResourcesProvider: StringResourcesProvider,
	savedStateHandle: SavedStateHandle
) : ViewModel() {

	private val _uiState = MutableStateFlow<ProductDetailsState>(ProductDetailsState.Loading)
	val uiState: StateFlow<ProductDetailsState> = _uiState.asStateFlow()

	private val _isFavourite = MutableStateFlow(false)
	val isFavourite: StateFlow<Boolean> = _isFavourite.asStateFlow()

	private val navArgs = savedStateHandle.toRoute<Screen.ProductDetails>()

	init {
		_isFavourite.value = navArgs.isFavourite
		getProductDetails(productCode = navArgs.productCode)
	}

	fun onEvent(event: ProductDetailsEvent) {
		when (event) {
			is ProductDetailsEvent.TryAgainClicked -> {
				getProductDetails(productCode = navArgs.productCode)
			}
			is ProductDetailsEvent.FavouriteClicked -> {

			}
		}
	}

	private fun getProductDetails(
		productCode: String
	) {
		_uiState.value = ProductDetailsState.Loading
		viewModelScope.launch {
			getProductDetailsUseCase(
				productCode = productCode
			).collect { response ->
				when (response) {
					is Response.Success -> handleProductDetailsSuccess(response.value)
					is Response.GenericError -> handleProductDetailsGenericError()
					is Response.NetworkError -> handleProductDetailsNetworkError()
				}
			}
		}
	}

	private fun handleProductDetailsSuccess(productDetails: ProductDetails) {
		_uiState.value = ProductDetailsState.Success(productDetails)
	}

	private fun handleProductDetailsGenericError() {
		_uiState.value = ProductDetailsState.Error(
			stringResourcesProvider.getString(R.string.generic_error_message)
		)
	}

	private fun handleProductDetailsNetworkError() {
		_uiState.value = ProductDetailsState.Error(
			stringResourcesProvider.getString(R.string.network_error_message)
		)
	}

	private fun toggleFavourite() {
		viewModelScope.launch {

		}
	}

}