package com.example.cryptoassignment.presentation.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cryptoassignment.domain.model.Home
import com.example.cryptoassignment.presentation.TransactionsAndPrices.CurrentPrices
import com.example.cryptoassignment.presentation.TransactionsAndPrices.RecentTransactionsSingleItem

@Composable
fun RecentTransactions(
    home: Home
) {
    LazyColumn(
        modifier = Modifier
            .padding(top = 15.dp, bottom = 15.dp)
    ) {
        items(home.all_transactions) { item ->
            RecentTransactionsSingleItem(item)
        }
    }
}

