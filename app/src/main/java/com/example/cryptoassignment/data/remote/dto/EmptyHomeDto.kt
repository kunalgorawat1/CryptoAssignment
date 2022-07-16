package com.example.cryptoassignment.data.remote.dto

import com.example.cryptoassignment.domain.model.EmptyHome

data class EmptyHomeDto(
    val all_transactions: List<Any>,
    val crypto_balance: CryptoBalance,
    val crypto_prices: List<CryptoPrice>,
    val your_crypto_holdings: List<YourCryptoHolding>
)

fun EmptyHomeDto.toEmptyHome(): EmptyHome {
    return EmptyHome(
        all_transactions = all_transactions,
        crypto_balance = crypto_balance,
        crypto_prices = crypto_prices,
        your_crypto_holdings = your_crypto_holdings
    )
}