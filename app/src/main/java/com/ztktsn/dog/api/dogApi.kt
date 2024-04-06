package com.ztktsn.dog.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object dogApi {
    val api: dogService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.api-ninjas.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(dogService::class.java)
    }
}