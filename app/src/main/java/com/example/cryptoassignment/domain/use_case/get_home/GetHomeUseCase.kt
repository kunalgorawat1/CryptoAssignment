package com.example.cryptoassignment.domain.use_case.get_home

import com.example.cryptoassignment.common.Resource
import com.example.cryptoassignment.data.remote.dto.toHome
import com.example.cryptoassignment.domain.model.Home
import com.example.cryptoassignment.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetHomeUseCase @Inject constructor(
    private val repository: HomeRepository
){
    operator fun invoke(): Flow<Resource<Home>> = flow {
        try {
            emit(Resource.Loading())
            val home = repository.getHome().toHome()
            emit(Resource.Success(home))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An Error occurred"))
        }
    }
}