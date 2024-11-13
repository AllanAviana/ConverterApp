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

@HiltViewModel
class ViewModel @Inject constructor(
    private val repository: CurrencyRepository
): ViewModel() {


    private val _UiState = MutableStateFlow(UiState())
    val uiState = _UiState.asStateFlow()


    fun updateAmount(newAmount: String){
        _UiState.update {
            it.copy(amount = newAmount)
        }
    }

    private fun updateFirstCountry(firstCountry: String){
        _UiState.update {
            it.copy(firstCountry = firstCountry)
        }
    }

    private fun updateSecondCountry(secondCountry: String){
        _UiState.update {
            it.copy(secondCountry = secondCountry)
        }
    }
    private fun updateFirstFlag(firstFlag: Int){
        _UiState.update {
            it.copy(firstFlag = firstFlag)
        }

    }
    private fun updateSecondFlag(secondFlag: Int){
        _UiState.update {
            it.copy(secondFlag = secondFlag)
        }
    }

    fun updateCountries(country: String, flag: Int){
        if(_UiState.value.countrySelected == 0){
            updateFirstCountry(country)
            updateFirstFlag(flag)
            _UiState.update {
                it.copy(countrySelected = 1)
            }
        }else{
            updateSecondCountry(country)
            updateSecondFlag(flag)
            _UiState.update {
                it.copy(countrySelected = 0)
            }
        }
    }
    fun converter() {
        viewModelScope.launch {
            _UiState.update {
                it.copy(
                    isNothing = false,
                    isLoading = true
                )
            }

            delay(1000)
            val result = repository.getCurrencyQuote("${uiState.value.firstCountry}-${uiState.value.secondCountry}")
            Log.d("repository", "Result: $result")
            if (result is ConverterUiState.Success && result.data != null) {
                val currencyQuote = result.data["${uiState.value.firstCountry}${uiState.value.secondCountry}"]
                Log.d("repository", "Currency Quote: $currencyQuote")
                val bid = currencyQuote!!.bid

                Log.d("repository", "Bid value: $bid")


                    _UiState.update { currentState ->
                        currentState.copy(number =bid.toFloat())
                    }

                _UiState.update { currentState ->
                    currentState.copy(result = (uiState.value.amount.toFloat() * uiState.value.number).toString())
                }

                _UiState.update {
                    it.copy(
                        isLoading = false,
                        isSuccess = true
                    )
                }
            } else {
                Log.e("repository", "Failed to fetch currency quote or data is null")
            }
        }
    }

    fun restart(){
        _UiState.update {
            it.copy(
                isSuccess = false,
                isNothing = true
            )
        }
    }



}