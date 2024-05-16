package com.example.mechtasmartphones.feature_catalog.data.model.product_details


import com.example.mechtasmartphones.feature_catalog.domain.model.product_details.MainProperty
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MainPropertyResponse(
    @Json(name = "code")
    val code: String?,
    @Json(name = "prop_id")
    val propId: Int?,
    @Json(name = "prop_name")
    val propName: String?,
    @Json(name = "prop_name_description")
    val propNameDescription: String?,
    @Json(name = "prop_value")
    val propValue: String?,
    @Json(name = "section_code")
    val sectionCode: Any?
) {

    companion object {
        fun toMainProperty(response: MainPropertyResponse): MainProperty {
            return MainProperty(
                propertyName = response.propName.orEmpty(),
                propertyValue = response.propValue.orEmpty()
            )
        }
    }

}