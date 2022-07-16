package com.example.cryptoassignment.data.remote.dto

import com.example.cryptoassignment.domain.model.Home

data class HomeDto(
    val all_transactions: List<AllTransaction>,
    val crypto_balance: CryptoBalance,
    val crypto_prices: List<CryptoPrice>,
    val your_crypto_holdings: List<YourCryptoHolding>
)

fun HomeDto.toHome(): Home {
    return Home(
        all_transactions = all_transactions,
        crypto_balance = crypto_balance,
        crypto_prices = crypto_prices,
        your_crypto_holdings = your_crypto_holdings
    )
}