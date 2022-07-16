package com.example.cryptoassignment.data.remote.dto

import retrofit2.http.GET

interface DemoApi {
    @GET("/home")
    suspend fun getHome(): HomeDto

    @GET("/empty-home")
    suspend fun getEmptyHome()
}