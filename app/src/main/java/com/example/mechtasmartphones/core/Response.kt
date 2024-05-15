package com.example.mechtasmartphones.core

import com.example.mechtasmartphones.core.data.util.ErrorResponse

sealed class Response<out T> {
	data class Success<out T>(val value: T): Response<T>()
	data class GenericError(val code: Int? = null, val error: ErrorResponse? = null): Response<Nothing>()
	data object NetworkError: Response<Nothing>()
}