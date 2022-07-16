package com.example.cryptoassignment.data.remote.dto

data class YourCryptoHolding(
    val current_bal_in_token: String,
    val current_bal_in_usd: String,
    val logo: String,
    val title: String
)