package com.example.cryptoassignment.presentation.home
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoassignment.common.Resource
import com.example.cryptoassignment.domain.model.Home
import com.example.cryptoassignment.domain.use_case.get_home.GetHomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeUseCase: GetHomeUseCase
): ViewModel() {
    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        getHome()
    }

    private fun getHome() {
        getHomeUseCase().onEach {  result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = HomeState(home = result.data)
                }

                is Resource.Loading -> {
                    _state.value = HomeState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = HomeState(
                        error = result.message ?: "An error occurred"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}