package org.d3if0146.assessment3mobpro.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if0146.assessment3mobpro.model.Motor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/" +
        "indraazimi/mobpro1-compose/static-api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MotorApiService {
    @GET("static-api.json")
    suspend fun getMotor(): List<Motor>
}

object MotorApi {
    val service: MotorApiService by lazy {
        retrofit.create(MotorApiService::class.java)
    }


    fun getMotorUrl(imageId: String): String {
        return "$BASE_URL$imageId.jpg"
    }
}