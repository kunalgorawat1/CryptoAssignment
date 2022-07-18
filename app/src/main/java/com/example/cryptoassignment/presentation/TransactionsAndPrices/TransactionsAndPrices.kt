package com.example.cryptoassignment.presentation.TransactionsAndPrices

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptoassignment.data.remote.dto.CryptoPrice
import com.example.cryptoassignment.presentation.home.HomeViewModel
import com.example.cryptoassignment.presentation.home.components.CryptoBalance
import com.example.cryptoassignment.presentation.home.components.RecentTransactions
import com.example.cryptoassignment.presentation.home.components.YourCryptoHoldings

@Composable
fun TransactionsAndPrices(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize(),

        ) {
        Column (){

            Spacer(modifier = Modifier
                .height(5.dp))

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
                elevation = 2.dp) {
                Column() {
                    Text(text = "Recent Transactions",
                        modifier = Modifier
                            .padding(top = 20.dp, start = 15.dp))
                    state.home?.let { RecentTransactions(home = it) }
                }
            }

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
                elevation = 2.dp) {
                Column() {
                    Text(text = "Current Prices",
                        modifier = Modifier
                            .padding(top = 20.dp, start = 15.dp))
                    state.home?.let { CurrentPrices(home = it) }
                }
            }

        }
    }
}