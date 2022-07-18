package com.example.cryptoassignment.presentation.TransactionsAndPrices

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cryptoassignment.domain.model.Home

@Composable
fun CurrentPrices(
    home: Home
) {

    LazyRow(
        modifier = Modifier
            .padding(15.dp)
    ) {
        items(home.crypto_prices) { item ->
            CurrentBalanceSingleItem(item)

        }
    }
}