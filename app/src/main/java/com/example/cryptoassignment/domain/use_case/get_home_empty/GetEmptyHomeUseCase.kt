package com.example.cryptoassignment.domain.use_case.get_home_empty

import com.example.cryptoassignment.common.Resource
import com.example.cryptoassignment.data.remote.dto.toEmptyHome
import com.example.cryptoassignment.data.remote.dto.toHome
import com.example.cryptoassignment.domain.model.EmptyHome
import com.example.cryptoassignment.domain.model.Home
import com.example.cryptoassignment.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetEmptyHomeUseCase @Inject constructor(
    private val repository: HomeRepository
){
    operator fun invoke(): Flow<Resource<EmptyHome>> = flow {
        try {
            emit(Resource.Loading())
            val emptyHome = repository.getEmptyHome().toEmptyHome()
            emit(Resource.Success(emptyHome))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An Error occurred"))
        }
    }
}