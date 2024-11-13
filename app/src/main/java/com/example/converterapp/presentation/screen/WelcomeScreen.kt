package com.example.converterapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.converterapp.R
import com.example.converterapp.presentation.navigation.AppNavigationRoute

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF3E4F75))
            .padding(top = 120.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Welcome to", fontSize = 28.sp, color = Color.White)
        Text(text = "Currency Converter", fontSize = 28.sp, color = Color.White)

        Spacer(modifier = Modifier.height(100.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f),
            Alignment.Center,
        ){
            CenterImage(
                Color(0xFFCAD2E2),
                modifier = Modifier
                    .width(210.dp)
                    .offset(y = (-75).dp),
                image = R.drawable.img_2,
                35,
                colorText = Color.Black,
                text = "RUB",
            )
            CenterImage(
                ColorImage = Color.White,
                modifier = Modifier
                    .width(235.dp)
                    .offset(y = (-38).dp),
                image = R.drawable.img_3,
                35,
                Color.Black,
                text = "EUR"
            )
            CenterImage(
                Color(0xFF899ABE),
                modifier = Modifier
                    .width(260.dp)
                    .zIndex(2f),
                image = R.drawable.img,
                45,
                Color.White,
                text = "USD"

            )
            CenterImage(
                    Color.White,
                modifier = Modifier
                    .width(235.dp)
                    .offset(y = (35).dp)
                    .zIndex(1f),
                image = R.drawable.img_5,
                35,
                Color.Black,
                text = "GBP"
            )
            CenterImage(
                Color(0xFFCAD2E2),
                modifier = Modifier
                    .width(210.dp)
                    .offset(y = (70).dp),
                image = R.drawable.img_4,
                35,
                Color.Black,
                text = "BRL")
            Box(
                modifier = Modifier
                    .fillMaxSize(0.8f)
                    .background(Color(0xFF3E4F75).copy(alpha = 0.4f))
                    .zIndex(3.0f)
            )
        }

        Spacer(modifier = Modifier.height(145.dp))
        StartButton(navController)
    }
}


@Composable
fun CenterImage(ColorImage: Color, modifier: Modifier, image: Int, size: Int, colorText: Color, text: String  ){
    Box(
        modifier = modifier
            .height(58.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color = ColorImage),
    ){
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 10.dp)
                .size(size.dp)
        )
        Text(text = text, color = colorText, fontSize = 14.sp, modifier = Modifier
            .align(Alignment.CenterStart)
            .padding(start = 60.dp))
    }
}


@Composable
fun StartButton(navController: NavHostController) {

    Box(
        modifier = Modifier
            .size(85.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(color = Color(0xFF899ABE).copy(alpha = 0.4f))
    ) {
        IconButton(
            onClick = { navController.navigate(AppNavigationRoute.ConversionScreen.route) },
            modifier = Modifier
                .size(73.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(color = Color(0xFF899ABE))
                .align(Alignment.Center)
        ) {

                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.White,
                )

        }

    }


}

