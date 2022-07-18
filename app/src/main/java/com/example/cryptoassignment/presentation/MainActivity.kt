package com.example.cryptoassignment.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptoassignment.presentation.TransactionsAndPrices.TransactionsAndPrices
import com.example.cryptoassignment.presentation.empty_home.components.EmptyHomeCompose
import com.example.cryptoassignment.presentation.home.components.HomeCompose
import com.example.cryptoassignment.presentation.navigation.Screen
import com.example.cryptoassignment.presentation.theme.CryptoAssignmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoAssignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CryptoApp(Screen.MainScreen.route)
                }
            }
        }
    }
}

@Composable
fun CryptoApp(name: String) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route)  {
        composable(route = Screen.MainScreen.route) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//            ) {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(130.dp)
                ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Button(onClick = {
                        navController.navigate(Screen.EmptyHomeScreen.route)
                    },
                        border = BorderStroke(1.dp, Color.Blue),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Blue),

                        )
                    {
                        Text(text = "Empty State")
                    }

                    Button(onClick = {
                        navController.navigate(Screen.HomeScreen.route)
                    },
                        border = BorderStroke(1.dp, Color.Blue),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Blue),

                        )
                    {
                        Text(text = "State")
                    }
                }
            }

//

//            }

        }

        composable(route = Screen.HomeScreen.route) {
            HomeCompose(navController = navController)
        }

        composable(route = Screen.EmptyHomeScreen.route) {
            EmptyHomeCompose(navController = navController)
        }

        composable(route = Screen.TransactionAndPricesScreen.route) {
            TransactionsAndPrices()
        }
    }


//    EmptyHomeCompose()
//    HomeCompose()
//    TransactionsAndPrices()
}
