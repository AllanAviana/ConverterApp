package com.example.converterapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.converterapp.presentation.screen.converterscreen.Converter
import com.example.converterapp.presentation.screen.WelcomeScreen
import com.example.converterapp.presentation.screen.viewmodel.ViewModel

@Composable
fun AppNavGraph(){
    val navController = rememberNavController()
    val viewModel: ViewModel = viewModel()

    NavHost(navController = navController, startDestination = AppNavigationRoute.WelcomeScreen.route){

        composable(route = AppNavigationRoute.WelcomeScreen.route){
            WelcomeScreen(navController)
        }

        composable(route = AppNavigationRoute.ConversionScreen.route){
            Converter(viewModel)
        }

    }

}