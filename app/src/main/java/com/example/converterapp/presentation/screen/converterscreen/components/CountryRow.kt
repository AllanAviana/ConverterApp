package com.example.converterapp.presentation.screen.converterscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.converterapp.presentation.screen.viewmodel.ViewModel
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.converterapp.presentation.screen.viewmodel.UiState


@Composable
fun CountryRow(
    country: String,
    imageId: Int,
    viewModel: ViewModel,
    isEnabled: Boolean,
    uiState: State<UiState>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.9f),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }) {
                    if (!isEnabled && uiState.value.firstCountry != country && uiState.value.secondCountry != country) {
                        viewModel.updateCountries(country, imageId)

                    }
                },
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                modifier = Modifier
                    .size(55.dp)
            )
            Text(text = country, fontSize = 15.sp)
        }
        if (uiState.value.firstCountry == country || uiState.value.secondCountry == country) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .clip(
                        shape = androidx.compose.foundation.shape.CircleShape
                    )
                    .background(
                        color = Color(0xFF3E4F75)
                    )
            )
        }

    }
}
