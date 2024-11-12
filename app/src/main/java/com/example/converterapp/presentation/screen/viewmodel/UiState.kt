package com.example.converterapp.presentation.screen.viewmodel

import com.example.converterapp.R

data class UiState(
    val amount: String = "",
    val number: Int = 0,
    val firstCountry: String = "USD",
    val secondCountry: String = "EUR",
    val firstFlag: Int = R.drawable.img,
    val secondFlag: Int = R.drawable.img_3,
    val countrySelected: Int = 0,

    )
