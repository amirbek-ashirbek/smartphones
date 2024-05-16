package com.example.mechtasmartphones.feature_catalog.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Database(entities = [ProductEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class ProductDatabase : RoomDatabase() {
	abstract fun productDao(): ProductDao
}


class Converters {
	@TypeConverter
	fun fromString(value: String): List<String> {
		return value.split(",").map { it.trim() }
	}

	@TypeConverter
	fun listToString(list: List<String>): String {
		return list.joinToString(",")
	}
}