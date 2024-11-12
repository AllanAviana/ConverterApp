package com.example.converterapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.converterapp.R
import com.example.converterapp.presentation.screen.viewmodel.ViewModel

@Composable
fun ConverterScreen(viewModel: ViewModel) {
    val uiState = viewModel.uiState.collectAsState()

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
        Row(
            modifier = Modifier
                .fillMaxWidth(0.7f)

        ) {
            Text(text = "Amount", color = Color.White)
        }
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = uiState.value.amount,
            onValueChange = {
                if (it.all { char -> char.isDigit() }) {
                    viewModel.updateAmount(it)
                }
            },
            placeholder = { Text("100", color = Color.Gray) },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_attach_money_24),
                    contentDescription = "Currency Icon",
                    tint = Color.Gray,


                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF1F1F1),
                unfocusedContainerColor = Color(0xFFF1F1F1),
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color(0xFF757575)
            ),
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(55.dp),
            textStyle = TextStyle(fontSize = 13.sp),
            shape = RoundedCornerShape(15.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
        )
        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(0.7f),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            OutlinedTextField(
                value = uiState.value.amount,
                onValueChange = {
                    if (it.all { char -> char.isDigit() }) {
                        viewModel.updateAmount(it)
                    }
                },
                placeholder = { Text(uiState.value.firstCountry, color = Color.Gray) },
                singleLine = true,
                leadingIcon = {
                    Image(
                        painter = painterResource(id = uiState.value.firstFlag),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                        )

                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF1F1F1),
                    unfocusedContainerColor = Color(0xFFF1F1F1),
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color(0xFF757575)
                ),
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .height(55.dp),
                textStyle = TextStyle(fontSize = 13.sp),
                shape = RoundedCornerShape(15.dp),
                readOnly = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
            )

            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier
                .align(Alignment.CenterVertically)
                .size(30.dp),
                tint = Color.White
            )

            OutlinedTextField(
                value = uiState.value.amount,
                onValueChange = {
                    if (it.all { char -> char.isDigit() }) {
                        viewModel.updateAmount(it)
                    }
                },
                placeholder = { Text(uiState.value.secondCountry, color = Color.Gray) },
                singleLine = true,
                leadingIcon = {
                    Image(
                        painter = painterResource(id = uiState.value.secondFlag),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF1F1F1),
                    unfocusedContainerColor = Color(0xFFF1F1F1),
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color(0xFF757575)
                ),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(55.dp),
                textStyle = TextStyle(fontSize = 13.sp),
                shape = RoundedCornerShape(15.dp),
                readOnly = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
            )

        }

        Spacer(modifier = Modifier.height(42.dp))



        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(52.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF021846)),
            shape = RoundedCornerShape(15.dp),
        ) {

            Text(text = "Convert", color = Color.White)

        }


        Spacer(modifier = Modifier.height(56.dp))



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
                CountryRow(country = country, imageId = imageId, viewModel)
            }
        }
    }
}

@Composable
fun CountryRow(country: String, imageId: Int, viewModel: ViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.3f)
            .clickable {
                viewModel.updateCountries(country, imageId)
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
        
        Text(text = country, fontSize = 15.sp )
        
    }
}
