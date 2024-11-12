package com.example.converterapp.presentation.navigation

sealed class AppNavigationRoute(val route: String) {
    object WelcomeScreen : AppNavigationRoute("welcome_screen")
    object ConversionScreen : AppNavigationRoute("conversion_screen")

}