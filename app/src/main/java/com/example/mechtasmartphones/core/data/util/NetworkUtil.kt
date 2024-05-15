package com.example.mechtasmartphones.core.data.util

import android.util.Log
import com.example.mechtasmartphones.core.Response
import com.squareup.moshi.Moshi
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NetworkUtil @Inject constructor(
	private val moshi: Moshi
) {

	suspend fun <T> safeApiCall(apiCall: suspend () -> T): Response<T> {
		return try {
			Response.Success(apiCall())
		} catch (e: HttpException) {
			Response.GenericError(e.code(), parseError(e.response()?.errorBody()))
		} catch (e: IOException) {
			Response.NetworkError
		} catch (e: Exception) {
			Log.d("what", "${e.message}")
			Response.GenericError()
		}
	}

	private fun parseError(responseBody: ResponseBody?): ErrorResponse? {
		return try {
			responseBody?.string()?.let { jsonString ->
				val adapter = moshi.adapter(ErrorResponse::class.java)
				adapter.fromJson(jsonString)
			}
		} catch (e: Exception) {
			null
		}
	}

}