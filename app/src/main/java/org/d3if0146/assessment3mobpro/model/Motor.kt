package org.d3if0146.assessment3mobpro.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Motor(

    @Json(name = "brand") val merek: String?,
    @Json(name = "category") val model: String?,
    @Json(name = "image") val imageId: String,
    @Json(name = "id") val id:String,
)
@JsonClass(generateAdapter = true)
data class MotorList(val products: List<Motor>)