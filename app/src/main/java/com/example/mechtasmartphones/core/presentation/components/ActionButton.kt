package com.example.mechtasmartphones.core.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ActionButton(
	text: String,
	onClick: () -> Unit,
	modifier: Modifier = Modifier,
	colors: ButtonColors = ButtonDefaults.buttonColors(
		disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
		disabledContentColor = MaterialTheme.colorScheme.onPrimary
	),
	enabled: Boolean = true
) {

	Button(
		onClick = onClick,
		colors = colors,
		shape = RoundedCornerShape(8.dp),
		enabled = enabled,
		modifier = modifier
			.height(36.dp)
	) {
		Text(
			text = text,
			style = MaterialTheme.typography.titleSmall
		)
	}

}