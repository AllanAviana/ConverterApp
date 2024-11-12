package com.example.converterapp.data.api

import com.example.converterapp.data.remote.model.CurrencyQuote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ConverterApi {
    @GET("{moedas}")
    suspend fun getCurrencyUsd(
        @Path("moedas") moedas: String,
    ): Response<Map<String, CurrencyQuote>>
}
