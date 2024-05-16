package com.example.mechtasmartphones.feature_catalog.di

import com.example.mechtasmartphones.core.data.util.NetworkUtil
import com.example.mechtasmartphones.feature_catalog.data.remote.CatalogApi
import com.example.mechtasmartphones.feature_catalog.data.repository.ProductRepositoryImpl
import com.example.mechtasmartphones.feature_catalog.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
	fun provideProductRepository(catalogApi: CatalogApi, networkUtil: NetworkUtil): ProductRepository {
		return ProductRepositoryImpl(
			catalogApi = catalogApi,
			networkUtil = networkUtil
		)
	}

}