package com.example.mechtasmartphones.feature_catalog.presentation.product_details_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mechtasmartphones.R
import com.example.mechtasmartphones.feature_catalog.domain.model.product_details.MainProperty
import com.example.mechtasmartphones.ui.theme.GrayBackground
import com.example.mechtasmartphones.ui.theme.GrayText

@Composable
fun ProductMainProperties(
	properties: List<MainProperty>,
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
			.fillMaxSize()
	) {
		Text(
			text = stringResource(id = R.string.main),
			style = MaterialTheme.typography.titleMedium
		)
		Spacer(modifier = Modifier.height(24.dp))
		MainPropertiesTable(properties = properties)
	}
}

@Composable
private fun MainPropertiesTable(
	properties: List<MainProperty>
) {
	properties.forEachIndexed { index, property ->

		val backgroundColor = if (index % 2 == 0) GrayBackground else MaterialTheme.colorScheme.background

		Box(
			contentAlignment = Alignment.Center,
			modifier = Modifier
				.fillMaxWidth()
				.background(
					color = backgroundColor,
					shape = RoundedCornerShape(6.dp)
				)
				.height(40.dp)
		) {
			Row(
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.fillMaxWidth()
					.padding(horizontal = 8.dp)
			) {
				Text(
					text = property.propertyName,
					style = MaterialTheme.typography.labelSmall.copy(
						color = GrayText
					),
					modifier = Modifier
						.weight(1f)
				)
				Spacer(modifier = Modifier.width(12.dp))
				Text(
					text = property.propertyValue,
					style = MaterialTheme.typography.labelMedium,
					modifier = Modifier
						.weight(1f)
				)
			}
		}
	}
}