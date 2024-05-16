package com.example.mechtasmartphones.feature_catalog.di

import android.content.Context
import androidx.room.Room
import com.example.mechtasmartphones.core.data.util.NetworkUtil
import com.example.mechtasmartphones.feature_catalog.data.local.ProductDao
import com.example.mechtasmartphones.feature_catalog.data.local.ProductDatabase
import com.example.mechtasmartphones.feature_catalog.data.remote.CatalogApi
import com.example.mechtasmartphones.feature_catalog.data.repository.ProductRepositoryImpl
import com.example.mechtasmartphones.feature_catalog.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CatalogModule {

	@Provides
	@Singleton
	fun provideCatalogApi(retrofit: Retrofit): CatalogApi {
		return retrofit.create(CatalogApi::class.java)
	}

	@Provides
	@Singleton
	fun provideProductRepository(catalogApi: CatalogApi, networkUtil: NetworkUtil, productDao: ProductDao): ProductRepository {
		return ProductRepositoryImpl(
			catalogApi = catalogApi,
			networkUtil = networkUtil,
			productDao = productDao
		)
	}

	@Provides
	@Singleton
	fun provideDatabase(@ApplicationContext context: Context): ProductDatabase {
		return Room.databaseBuilder(
			context.applicationContext,
			ProductDatabase::class.java,
			"product_database"
		).build()
	}

	@Provides
	fun provideProductDao(database: ProductDatabase): ProductDao {
		return database.productDao()
	}

}