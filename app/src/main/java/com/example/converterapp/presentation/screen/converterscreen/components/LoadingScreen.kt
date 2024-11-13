package com.example.converterapp.presentation.screen.converterscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.converterapp.R
import com.example.converterapp.presentation.screen.viewmodel.ViewModel

@Composable
fun LoadingScreen(viewModel: ViewModel) {
    val countryImage: Map<String, Int> = mapOf(
        "BRL" to R.drawable.img_4,
        "USD" to R.drawable.img,
        "RUB" to R.drawable.img_2,
        "GBP" to R.drawable.img_5,
        "EUR" to R.drawable.img_3
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF3E4F75))
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF3E4F75))
                .fillMaxHeight(0.32f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }

        Box(
            modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                    .background(Color.White)
                    .padding(start = 16.dp, top = 32.dp, end = 16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                countryImage.forEach { (country, imageId) ->
                    CountryRow(country = country, imageId = imageId, viewModel, isEnabled = true)
                }
            }
            Box(
                modifier = Modifier.fillMaxSize().background(Color.White.copy(alpha = 0.65f))
            )
        }
    }
}