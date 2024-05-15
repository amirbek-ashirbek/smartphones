package com.example.mechtasmartphones.core.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.mechtasmartphones.BuildConfig
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

	@Provides
	@Singleton
	fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
		return Retrofit.Builder()
			.client(okHttpClient)
			.baseUrl(BuildConfig.BASE_URL)
			.addConverterFactory(MoshiConverterFactory.create())
			.build()
	}

	@Provides
	@Singleton
	fun provideHttpClient(
		@ApplicationContext context: Context
	): OkHttpClient {
		return OkHttpClient.Builder()
			.addInterceptor(ChuckerInterceptor(context = context))
			.build()
	}

	@Provides
	@Singleton
	fun provideMoshi(): Moshi {
		return Moshi.Builder()
			.build()
	}

}