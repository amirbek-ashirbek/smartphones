package com.example.mechtasmartphones.feature_catalog.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mechtasmartphones.feature_catalog.domain.model.product.ProductItem

@Entity(tableName = ProductEntity.TABLE_NAME)
data class ProductEntity(
	@PrimaryKey val id: Int,
	val name: String,
	val code: String,
	val price: Int,
	val imageUrls: List<String>,
	val isFavourite: Boolean
) {

	companion object {

		const val TABLE_NAME = "favourite_products"

		fun toProductItem(entity: ProductEntity): ProductItem {
			return ProductItem(
				id = entity.id,
				code = entity.code,
				imageUrls = entity.imageUrls,
				name = entity.name,
				price = entity.price
			)
		}

		fun toProductEntity(product: ProductItem): ProductEntity {
			return ProductEntity(
				id = product.id,
				code = product.code,
				price = product.price,
				name = product.name,
				isFavourite = product.isFavourite,
				imageUrls = product.imageUrls
			)
		}

	}
}
