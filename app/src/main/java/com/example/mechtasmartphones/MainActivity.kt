package com.example.mechtasmartphones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mechtasmartphones.feature_catalog.presentation.product_list_screen.ProductListScreen
import com.example.mechtasmartphones.ui.theme.MechtaSmartphonesTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			MechtaSmartphonesTheme {
				val navController = rememberNavController()
				NavHost(
					navController = navController,
					startDestination = ProductList
				) {
					composable<ProductList> {
						ProductListScreen()
					}
				}
			}
		}
	}
}

@Serializable
object ProductList