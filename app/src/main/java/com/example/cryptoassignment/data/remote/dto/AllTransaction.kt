package com.example.cryptoassignment.data.remote.dto

data class AllTransaction(
    val title: String,
    val txn_amount: String,
    val txn_logo: String,
    val txn_sub_amount: String,
    val txn_time: String
)