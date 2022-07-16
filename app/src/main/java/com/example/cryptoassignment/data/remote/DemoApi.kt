package com.example.cryptoassignment.data.remote

import com.example.cryptoassignment.data.remote.dto.EmptyHomeDto
import com.example.cryptoassignment.data.remote.dto.HomeDto
import retrofit2.http.GET

interface DemoApi {
    @GET("/home")
    suspend fun getHome(): HomeDto

    @GET("/empty-home")
    suspend fun getEmptyHome(): EmptyHomeDto
}