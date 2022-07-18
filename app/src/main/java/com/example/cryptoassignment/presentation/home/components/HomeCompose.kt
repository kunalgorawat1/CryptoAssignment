package com.example.cryptoassignment.presentation.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptoassignment.presentation.home.HomeViewModel
import com.example.cryptoassignment.presentation.navigation.Screen

@Composable
fun HomeCompose(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val text by remember {
        mutableStateOf(Screen.HomeScreen.route)
    }


    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize(),

    ) {
        Column (){

            state.home?.let { CryptoBalance(home = it) }

            Spacer(modifier = Modifier
                .height(5.dp))
//            Divider(color = Color.Black, thickness = 1.dp)

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
                elevation = 2.dp) {
                Column() {
                    Text(text = "Your Crypto Holdings",
                        modifier = Modifier
                            .padding(top = 20.dp, start = 15.dp))
                    state.home?.let { YourCryptoHoldings(home = it) }
                }
            }

            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
                ) {
                    Button(onClick = {
                        navController.navigate(Screen.TransactionAndPricesScreen.route)
                    },
//                        border = BorderStroke(1.dp, Color.Blue),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Blue)
                    )
                    {
                        Text(text = "Transaction And Prices")
                    }
            }

        }
    }
}

