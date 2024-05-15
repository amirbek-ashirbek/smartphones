package com.example.mechtasmartphones.feature_catalog.presentation.product_list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mechtasmartphones.core.Response
import com.example.mechtasmartphones.core.presentation.pagination.PaginatorImpl
import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductItem
import com.example.mechtasmartphones.feature_catalog.domain.use_case.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
	private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

	private val _uiState = MutableStateFlow(ProductListState())
	val uiState: StateFlow<ProductListState> = _uiState.asStateFlow()

	private val productsPaginator = PaginatorImpl(
		initialKey = 1,
		getNextKey = {
			_uiState.value.productsPage +1
		},
		onRequest = { nextPage ->
			getProductsUseCase(
				section = "smartfony",
				page = nextPage,
				pageLimit = 20
			)
		},
		onLoadingUpdated = { isLoading ->
			_uiState.update { it.copy(productsAreLoading = isLoading) }
		},
		onError = { response ->
			handleProductsError(response)
		},
		onSuccess = { nextProducts, newKey ->
			handleProductsSuccess(
				products = nextProducts,
				newKey = newKey
			)
		}
	)

	init {
		loadNextProducts()
	}

	fun onEvent(event: ProductListEvent) {
		when (event) {
			is ProductListEvent.UserScrolledToListEnd -> {
				loadNextProducts()
			}
		}
	}

	private fun loadNextProducts() {
		viewModelScope.launch {
			if (_uiState.value.productsAreLoading) {
				return@launch
			}
			productsPaginator.loadNextItems()
		}
	}

	private fun handleProductsSuccess(
		products: List<ProductItem>,
		newKey: Int
	) {
		_uiState.update { currentState ->

			// Checking for unique IDs because backend returns the same product twice (ID 78716)
			val existingProductIds = currentState.products.map { it.id }.toSet()
			val newUniqueProducts = products.filter { it.id !in existingProductIds }

			currentState.copy(
				products = currentState.products + newUniqueProducts,
				productsPage = newKey,
				productsEndReached = newUniqueProducts.isEmpty() || (currentState.productsPage == 1 && newUniqueProducts.size < 20)
			)
		}
	}

	private fun handleProductsError(response: Response<*>) {

	}

}