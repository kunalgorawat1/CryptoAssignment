package com.example.cryptoassignment.presentation.home.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptoassignment.presentation.home.HomeViewModel

@Composable
fun HomeCompose(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Text(text = "Kunal Home compose ${state.home.toString()}")
}