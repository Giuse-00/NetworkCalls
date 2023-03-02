package com.android.example.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class instanceRetrofit {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(DogApiService::class.java)

}