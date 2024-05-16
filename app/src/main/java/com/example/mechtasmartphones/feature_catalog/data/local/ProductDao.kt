package com.example.mechtasmartphones.feature_catalog.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
	@Query("SELECT * FROM favourite_products")
	suspend fun getFavoriteProducts(): List<ProductEntity>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun addProductToFavorites(product: ProductEntity)

	@Query("DELETE FROM favourite_products WHERE id = :productId")
	suspend fun deleteProductFromFavorites(productId: Int)
}