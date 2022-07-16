package com.example.cryptoassignment.presentation.empty_home

import com.example.cryptoassignment.domain.model.EmptyHome
import com.example.cryptoassignment.domain.model.Home

data class EmptyHomeState(
    val isLoading: Boolean = false,
    val home: EmptyHome? = null,
    val error: String = ""
)
