package com.example.cryptoassignment.domain.model

import com.example.cryptoassignment.data.remote.dto.CryptoBalance
import com.example.cryptoassignment.data.remote.dto.CryptoPrice
import com.example.cryptoassignment.data.remote.dto.YourCryptoHolding

data class EmptyHome(
    val all_transactions: List<Any>,
    val crypto_balance: CryptoBalance,
    val crypto_prices: List<CryptoPrice>,
    val your_crypto_holdings: List<YourCryptoHolding>
)
