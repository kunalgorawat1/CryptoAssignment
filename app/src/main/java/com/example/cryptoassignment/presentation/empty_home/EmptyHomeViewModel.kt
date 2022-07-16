package com.example.cryptoassignment.presentation.empty_home.components
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoassignment.common.Resource
import com.example.cryptoassignment.domain.use_case.get_home_empty.GetEmptyHomeUseCase
import com.example.cryptoassignment.presentation.empty_home.EmptyHomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class EmptyHomeViewModel @Inject constructor(
    private val getEmptyHomeUseCase: GetEmptyHomeUseCase
): ViewModel() {
    private val _state = mutableStateOf(EmptyHomeState())
    val state: State<EmptyHomeState> = _state

    init {
        getHome()
    }
    
    private fun getHome() {
        getEmptyHomeUseCase().onEach {  result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = EmptyHomeState(home = result.data)
                }

                is Resource.Loading -> {
                    _state.value = EmptyHomeState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = EmptyHomeState(
                        error = result.message ?: "An error occurred"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}