package com.example.mechtasmartphones.core.data.util

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorResponse(
	@Json(name = "errors")
	val errors: List<String>
)
