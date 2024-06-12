package org.d3if0146.assessment3mobpro.network

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.d3if0146.assessment3mobpro.model.Motor
import org.d3if0146.assessment3mobpro.model.OpStatus
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


private const val BASE_URL = "https://4602myproductapi.000webhostapp.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MotorApiService {
    @GET("/6706220146/product")
    suspend fun getMotor(
        @Header("Authorization") userId: String
    ): List<Motor>

    @Multipart
    @POST("/6706220146/product")
    suspend fun postMotor(
        @Header("Authorization") userId: String,
        @Part("brand") merek: RequestBody,
        @Part("category") model: RequestBody,
        @Part image: MultipartBody.Part
    ): OpStatus
}

object MotorApi {
    val service: MotorApiService by lazy {
        retrofit.create(MotorApiService::class.java)
    }


    fun getMotorUrl(imageId: String): String {
        return "${BASE_URL}/images/${imageId}"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }