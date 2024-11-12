package com.example.converterapp.data.repository

import com.example.converterapp.data.api.ConverterApi
import com.example.converterapp.data.remote.model.ConverterUiState
import com.example.converterapp.data.remote.model.CurrencyQuote
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CurrencyRepository @Inject constructor(
    private val api: ConverterApi
) {
    suspend fun getCurrencyQuote(moedas: String): ConverterUiState<Map<String, CurrencyQuote>> {
        return withContext(Dispatchers.IO) {
            try {
                ConverterUiState.Loading
                val response = api.getCurrencyUsd(moedas)
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        ConverterUiState.Success(body)
                    } else {
                        ConverterUiState.Error("Empty response")
                    }
                } else {
                    ConverterUiState.Error("Failed to fetch data: ${response.message()}")
                }
            } catch (e: Exception) {
                ConverterUiState.Error("An error occurred: ${e.message}")
            }
        }
    }
}