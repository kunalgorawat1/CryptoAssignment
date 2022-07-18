package com.example.cryptoassignment.presentation.navigation

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object HomeScreen: Screen("home_screen")
    object EmptyHomeScreen: Screen("empty_home_screen")
    object TransactionAndPricesScreen: Screen("transaction_and_prices_screen")

}
