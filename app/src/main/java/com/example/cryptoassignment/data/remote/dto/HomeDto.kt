package com.example.cryptoassignment.data.remote.dto

data class HomeDto(
    val all_transactions: List<AllTransaction>,
    val crypto_balance: CryptoBalance,
    val crypto_prices: List<CryptoPrice>,
    val your_crypto_holdings: List<YourCryptoHolding>
)