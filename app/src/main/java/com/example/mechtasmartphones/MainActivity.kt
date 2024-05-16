package com.example.mechtasmartphones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mechtasmartphones.feature_catalog.presentation.product_details_screen.ProductDetailsScreen
import com.example.mechtasmartphones.feature_catalog.presentation.product_list_screen.ProductListScreen
import com.example.mechtasmartphones.navigation.Screen
import com.example.mechtasmartphones.navigation.canGoBack
import com.example.mechtasmartphones.ui.theme.MechtaSmartphonesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
//		enableEdgeToEdge()
		setContent {
			MechtaSmartphonesTheme {
				val navController = rememberNavController()
				NavHost(
					navController = navController,
					startDestination = Screen.ProductList
				) {
					composable<Screen.ProductList> {
						ProductListScreen(
							onNavigateToProductDetails = { productCode, isFavourite ->
								navController.navigate(
									Screen.ProductDetails(
										productCode = productCode,
										isFavourite = isFavourite
									)
								)
							}
						)
					}
					composable<Screen.ProductDetails> {
						ProductDetailsScreen(
							onBackClicked = {
								if (navController.canGoBack) {
									navController.popBackStack()
								}
							}
						)
					}
				}
			}
		}
	}
}