package com.ztktsn.dog.api

import com.ztktsn.dog.dog
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface dogService {
    @Headers("X-Api-Key:axm8a24PRFO/XTjGe9sqLQ==mebP8xwUuaDGiyHn")
    @GET("dogs")
    fun getDogByName(@Query("name") name: String): Call<List<dog>>
}