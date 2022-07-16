package com.example.cryptoassignment.presentation.home

import com.example.cryptoassignment.domain.model.Home

data class HomeState(
    val isLoading: Boolean = false,
    val home: Home? = null,
    val error: String = ""
)
