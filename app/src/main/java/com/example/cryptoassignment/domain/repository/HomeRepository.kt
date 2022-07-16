package com.example.cryptoassignment.domain.repository

import com.example.cryptoassignment.data.remote.dto.EmptyHomeDto
import com.example.cryptoassignment.data.remote.dto.HomeDto

interface HomeRepository {

    suspend fun getHome(): HomeDto

    suspend fun getEmptyHome(): EmptyHomeDto
}