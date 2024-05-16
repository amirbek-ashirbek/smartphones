package com.example.mechtasmartphones.feature_catalog.presentation.product_list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mechtasmartphones.core.Response
import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductItem
import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductsData
import com.example.mechtasmartphones.feature_catalog.domain.use_case.GetProductsUseCase
import com.example.mechtasmartphones.feature_catalog.presentation.ProductsPaginator
import com.example.mechtasmartphones.feature_catalog.presentation.util.Constants.PRODUCTS_PAGE_SIZE
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

	private val productsPaginator = ProductsPaginator<Int, ProductItem>(
		initialKey = 1,
		getNextKey = {
			_uiState.value.productsPage +1
		},
		onRequest = { nextPage ->
			getProductsUseCase(
				section = "smartfony",
				page = nextPage,
				pageLimit = PRODUCTS_PAGE_SIZE
			)
		},
		onLoadingUpdated = { isLoading ->
			_uiState.update { it.copy(productsAreLoading = isLoading) }
		},
		onError = { response ->
			handleProductsError(response)
		},
		onSuccess = { nextProductsData, newKey ->
			handleProductsSuccess(
				productsData = nextProductsData,
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
		productsData: ProductsData,
		newKey: Int
	) {
		_uiState.update { currentState ->
			val products = productsData.items
			// Checking for unique IDs because backend returns the same product twice (ID 78716)
			val existingProductIds = currentState.products.map { it.id }.toSet()
			val newUniqueProducts = products.filter { it.id !in existingProductIds }

			currentState.copy(
				products = currentState.products + newUniqueProducts,
				productsPage = newKey,
				productsEndReached = newUniqueProducts.isEmpty() || (currentState.productsPage == 1 && newUniqueProducts.size < PRODUCTS_PAGE_SIZE)
			)
		}
	}

	private fun handleProductsError(response: Response<*>) {

	}

}