package com.example.cryptoassignment.data.repository

import com.example.cryptoassignment.data.remote.DemoApi
import com.example.cryptoassignment.data.remote.dto.EmptyHomeDto
import com.example.cryptoassignment.data.remote.dto.HomeDto
import com.example.cryptoassignment.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImplementation @Inject constructor(
    private val api: DemoApi
): HomeRepository {

    override suspend fun getHome(): HomeDto {
        return api.getHome()
    }

    override suspend fun getEmptyHome(): EmptyHomeDto {
        return api.getEmptyHome()
    }

}