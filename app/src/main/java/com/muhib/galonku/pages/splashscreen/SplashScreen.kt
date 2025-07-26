package com.muhib.galonku.pages.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.muhib.galonku.AppScreen
import com.muhib.galonku.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xff799EFF))
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_galon),
            contentScale = ContentScale.FillBounds,
            contentDescription = "logo", modifier = Modifier.align(Alignment.Center)
        )

    }

}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())

}