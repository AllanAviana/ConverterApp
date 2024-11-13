package com.example.converterapp.presentation.screen.converterscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.converterapp.R
import com.example.converterapp.presentation.screen.viewmodel.UiState
import com.example.converterapp.presentation.screen.viewmodel.ViewModel

@Composable
fun SuccessScreen(viewModel: ViewModel, uiState: State<UiState>) {
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Column{
                Text(text = "Result", color = Color.White)
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .width(260.dp)
                        .height(53.dp)
                        .clip(RoundedCornerShape(15))
                        .background(Color.White)
                ) {
                    Image(
                        painter = painterResource(id = uiState.value.firstFlag),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.CenterStart)
                    )

                    Text(
                        uiState.value.firstCountry,
                        modifier = Modifier.align(Alignment.CenterStart).padding(start = 60.dp),
                        fontSize = 15.sp
                    )
                    Text(
                        uiState.value.amount,
                        modifier = Modifier.align(Alignment.CenterEnd).padding(end = 24.dp),
                        fontSize = 15.sp
                    )
                }
            }

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_downward_24),
                contentDescription = null,
                modifier = Modifier.size(30.dp),
                tint = Color.White
            )

            Box(
                modifier = Modifier
                    .width(260.dp)
                    .height(53.dp)
                    .clip(RoundedCornerShape(15))
                    .background(Color.White)
            ){
                Image(
                    painter = painterResource(id = uiState.value.secondFlag),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.CenterStart)
                )

                Text(uiState.value.secondCountry, modifier = Modifier.align(Alignment.CenterStart).padding(start = 60.dp), fontSize = 15.sp)
                Text(uiState.value.result, modifier = Modifier.align(Alignment.CenterEnd).padding(end = 24.dp), fontSize = 15.sp)
            }

            Button(
                onClick = { viewModel.restart() },
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF021846)),
                shape = RoundedCornerShape(15.dp),
            ) {

                Text(text = "Do another conversion", color = Color.White)
            }
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