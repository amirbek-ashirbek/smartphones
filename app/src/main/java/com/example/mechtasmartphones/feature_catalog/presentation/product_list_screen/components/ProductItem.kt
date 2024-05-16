package com.example.mechtasmartphones.feature_catalog.presentation.product_list_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mechtasmartphones.R
import com.example.mechtasmartphones.core.presentation.util.noRippleClickable
import com.example.mechtasmartphones.ui.theme.SomeGray

@Composable
fun ProductItem(
	name: String,
	price: Int,
	imageUrl: String,
	isFavourite: Boolean,
	modifier: Modifier = Modifier
) {
	Card(
		onClick = { },
		shape = RoundedCornerShape(6.dp),
		colors = CardDefaults.cardColors(
			containerColor = MaterialTheme.colorScheme.background
		),
		elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
		modifier = modifier
	) {
		Box {
			Column(
				modifier = Modifier
					.fillMaxWidth()
					.padding(horizontal = 6.dp, vertical = 4.dp)
			) {
				ProductImage(url = imageUrl)
				Spacer(modifier = Modifier.height(8.dp))
				ProductNameText(name = name)
				Spacer(modifier = Modifier.height(24.dp))
				ProductPriceText(price = price)
				Spacer(modifier = Modifier.height(12.dp))
			}
			FavouriteIcon(
				isFavourite = isFavourite,
				onClick = { TODO() },
				modifier = Modifier
					.align(Alignment.TopEnd)
					.padding(top = 12.dp, end = 12.dp)
			)
		}
	}
}

@Composable
private fun ProductImage(
	url: String
) {
	AsyncImage(
		model = url,
		contentDescription = null
	)
}

@Composable
private fun ProductNameText(
	name: String
) {
	Text(
		text = name,
		style = MaterialTheme.typography.bodyMedium,
		maxLines = 2,
		overflow = TextOverflow.Ellipsis
	)
}

@Composable
fun FavouriteIcon(
	isFavourite: Boolean,
	onClick: () -> Unit,
	modifier: Modifier = Modifier
) {

	val iconColor = if (isFavourite) MaterialTheme.colorScheme.primary else SomeGray

	Icon(
		imageVector = Icons.Default.FavoriteBorder,
		contentDescription = null,
		tint = iconColor,
		modifier = modifier
			.noRippleClickable(
				onClick = onClick
			)
	)
}

@Composable
private fun ProductPriceText(
	price: Int
) {
	Text(
		text = stringResource(id = R.string.product_price, price),
		style = MaterialTheme.typography.titleMedium
	)
}