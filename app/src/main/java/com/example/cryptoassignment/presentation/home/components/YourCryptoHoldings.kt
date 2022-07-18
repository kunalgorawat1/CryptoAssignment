package com.example.cryptoassignment.presentation.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cryptoassignment.data.remote.dto.YourCryptoHolding
import com.example.cryptoassignment.domain.model.Home
import com.google.accompanist.flowlayout.FlowColumn

@Composable
fun YourCryptoHoldings(
    home: Home
) {
        LazyColumn(
            modifier = Modifier
                .padding(top = 15.dp, bottom = 15.dp)
        ) {
            items(home.your_crypto_holdings) { item ->
                HoldingsSingleItem(yourCryptoHolding = item)
            }
        }
}