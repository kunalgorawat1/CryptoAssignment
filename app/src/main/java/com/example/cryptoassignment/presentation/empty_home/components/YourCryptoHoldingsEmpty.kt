package com.example.cryptoassignment.presentation.empty_home.components
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cryptoassignment.domain.model.EmptyHome

@Composable
fun YourCryptoHoldingsEmpty(
    home: EmptyHome
) {
    LazyColumn(
        modifier = Modifier
            .padding(top = 15.dp, bottom = 15.dp)
    ) {
        items(home.your_crypto_holdings) { item ->
            HoldingsSingleItemEmpty(yourCryptoHolding = item)
        }
    }
}