package com.example.converterapp.presentation.screen.viewmodel

import com.example.converterapp.R

data class UiState(
    val amount: String = "",
    val number: Float = 0.0F,
    val firstCountry: String = "USD",
    val secondCountry: String = "EUR",
    val firstFlag: Int = R.drawable.usd,
    val secondFlag: Int = R.drawable.eur,
    val countrySelected: Int = 0,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val isNothing: Boolean = true,
    val result: String = "",

    )
