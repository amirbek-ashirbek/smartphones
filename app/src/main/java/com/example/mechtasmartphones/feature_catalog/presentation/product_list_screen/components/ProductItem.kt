package com.example.mechtasmartphones.feature_catalog.presentation.product_list_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductItem(
	name: String
) {
	Column {
		Text(
			text = name
		)
		Spacer(modifier = Modifier.height(32.dp))
	}
}