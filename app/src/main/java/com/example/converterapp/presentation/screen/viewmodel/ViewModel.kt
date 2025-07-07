package com.example.converterapp.presentation.screen.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.converterapp.data.remote.model.ConverterUiState
import com.example.converterapp.data.repository.CurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel responsible for handling user input and currency–conversion logic.
 */
@HiltViewModel
class ViewModel @Inject constructor(
    private val repository: CurrencyRepository
) : ViewModel() {

    /* ---------- UI STATE ---------- */

    // Backing state (mutable inside the ViewModel)
    private val _UIState = MutableStateFlow(UiState())
    // State exposed to the UI (immutable)
    val uiState = _UIState.asStateFlow()

    /* ---------- PUBLIC API ---------- */

    /**
     * Update the amount entered by the user.
     */
    fun updateAmount(newAmount: String) {
        _UIState.update { it.copy(amount = newAmount) }
    }

    /**
     * User selected a country and its flag.
     * The first click sets the "from" country; the second click sets the "to" country.
     */
    fun updateCountries(country: String, flag: Int) {
        if (_UIState.value.countrySelected == 0) {
            updateFirstCountry(country)
            updateFirstFlag(flag)
            _UIState.update { it.copy(countrySelected = 1) }
        } else {
            updateSecondCountry(country)
            updateSecondFlag(flag)
            _UIState.update { it.copy(countrySelected = 0) }
        }
    }

    fun converter() {
        if (uiState.value.amount.isNotEmpty()) {
            viewModelScope.launch {
                // Show loading state
                _UIState.update { it.copy(isNothing = false, isLoading = true) }

                delay(1000) // Simulate network latency for UX purposes

                // Build the currency pair, e.g., "USD-BRL"
                val pair = "${uiState.value.firstCountry}-${uiState.value.secondCountry}"
                val result = repository.getCurrencyQuote(pair)

                if (result is ConverterUiState.Success && result.data != null) {
                    // Extract the bid (exchange rate)
                    val bid = result.data["${uiState.value.firstCountry}${uiState.value.secondCountry}"]!!.bid

                    // Store the numeric rate in state
                    _UIState.update { current -> current.copy(number = bid.toFloat()) }

                    // Calculate the conversion and update the result
                    _UIState.update { current ->
                        current.copy(
                            result = (uiState.value.amount.toFloat() * uiState.value.number).toString()
                        )
                    }

                    // Hide loading, show success
                    _UIState.update { it.copy(isLoading = false, isSuccess = true) }
                } else {
                    Log.e("repository", "Failed to fetch currency quote or data is null")
                }
            }
        }
    }

    /**
     * Reset the UI back to the initial state after a successful conversion.
     */
    fun restart() {
        _UIState.update { it.copy(isSuccess = false, isNothing = true) }
    }

    /* ---------- PRIVATE HELPERS ---------- */

    private fun updateFirstCountry(firstCountry: String) {
        _UIState.update { it.copy(firstCountry = firstCountry) }
    }

    private fun updateSecondCountry(secondCountry: String) {
        _UIState.update { it.copy(secondCountry = secondCountry) }
    }

    private fun updateFirstFlag(firstFlag: Int) {
        _UIState.update { it.copy(firstFlag = firstFlag) }
    }

    private fun updateSecondFlag(secondFlag: Int) {
        _UIState.update { it.copy(secondFlag = secondFlag) }
    }
}
