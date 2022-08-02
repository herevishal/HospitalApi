package com.example.recyapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class ApiClient {
    public var BASE_URL: String = "https://next.json-generator.com/api/json/get/"
    public var retrofit: Retrofit? = null

    public fun getApiClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }
}
