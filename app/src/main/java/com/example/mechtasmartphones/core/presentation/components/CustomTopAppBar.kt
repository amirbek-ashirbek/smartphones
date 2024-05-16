package com.example.mechtasmartphones.core.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
	onBackClicked: () -> Unit,
	actionIcon: ImageVector,
	onActionIconClicked: () -> Unit,
	modifier: Modifier = Modifier,
	colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors()
) {
	CenterAlignedTopAppBar(
		title = {},
		navigationIcon = {
			IconButton(onClick = onBackClicked) {
				Icon(
					imageVector = Icons.AutoMirrored.Default.ArrowBack,
					contentDescription = null
				)
			}
		},
		actions = {
			IconButton(
				onClick = onActionIconClicked
			) {
				Icon(
					imageVector = actionIcon,
					contentDescription = null
				)
			}
		},
		colors = colors,
		modifier = modifier
	)
}