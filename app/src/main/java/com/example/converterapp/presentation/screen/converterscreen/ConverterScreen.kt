package com.example.converterapp.presentation.screen.converterscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.converterapp.presentation.screen.converterscreen.components.HomeScreen
import com.example.converterapp.presentation.screen.converterscreen.components.LoadingScreen
import com.example.converterapp.presentation.screen.converterscreen.components.SuccessScreen
import com.example.converterapp.presentation.screen.viewmodel.ViewModel

@Composable
fun Converter(viewModel: ViewModel){
    val uiState = viewModel.uiState.collectAsState()
   if(uiState.value.isNothing){
       HomeScreen(viewModel, uiState)
   }else if(uiState.value.isLoading){
       LoadingScreen(viewModel)
   }else if(uiState.value.isSuccess){
       SuccessScreen(viewModel, uiState)
   }
}