package com.example.cryptoassignment.data.remote.dto

data class EmptyHomeDto(
    val all_transactions: List<Any>,
    val crypto_balance: CryptoBalance,
    val crypto_prices: List<CryptoPrice>,
    val your_crypto_holdings: List<YourCryptoHolding>
)