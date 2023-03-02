package com.android.example.network

import retrofit2.http.GET

interface DogApiService {
    @GET("/api/breeds/list/all")

    suspend fun getDetails() : Data
}