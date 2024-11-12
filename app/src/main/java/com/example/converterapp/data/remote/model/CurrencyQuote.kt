package com.example.converterapp.data.remote.model

sealed class ConverterUiState<out T>{
    data object Loading : ConverterUiState<Nothing>()
    data class Error(val message: String) : ConverterUiState<Nothing>()
    data class Success<T>(val data: T) : ConverterUiState<T>()
}

data class CurrencyQuote(
    val code: String,
    val codein: String,
    val name: String,
    val high: String,
    val low: String,
    val varBid: String,
    val pctChange: String,
    val bid: String,
    val ask: String,
    val timestamp: String,
    val create_date: String
)
