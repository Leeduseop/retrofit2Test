package com.sensor.test_sensor.retrofit2

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


object RetrofitClient {
    private var instance: RetrofitClient? = null
    private const val baseUrl = "http://api.airvisual.com/v2/nearest_city"

    fun getInstance(): RetrofitClient? {
        if (instance == null) {
            instance = RetrofitClient
        }
        return instance
    }

    private var defaultHttpClient: OkHttpClient? =
        OkHttpClient.Builder().addInterceptor { chain ->
            val request: Request = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .build()
            chain.proceed(request)
        }.build()


    private var retrofit: Retrofit? = Retrofit.Builder()
        .baseUrl(baseUrl)
        //.addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(defaultHttpClient)
        .build()

    private var rtroService: RetrofitService? = retrofit?.create(
            RetrofitService::class.java)

    fun getService(): RetrofitService? {
        return rtroService
    }

}