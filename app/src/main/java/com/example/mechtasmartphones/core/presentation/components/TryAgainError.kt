package com.example.mechtasmartphones.core.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mechtasmartphones.R

@Composable
fun TryAgainError(
	errorMessage: String,
	onTryAgainClicked: () -> Unit
) {
	Box(
		modifier = Modifier
			.fillMaxSize()
	) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center,
			modifier = Modifier.align(Alignment.Center)
		) {
			Text(
				text = errorMessage
			)
			Spacer(modifier = Modifier.height(16.dp))
			Button(
				onClick = onTryAgainClicked
			) {
				Text(
					text = stringResource(id = R.string.refresh)
				)
			}
		}
	}
}