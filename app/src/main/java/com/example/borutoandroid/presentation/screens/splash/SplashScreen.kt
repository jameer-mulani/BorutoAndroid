package com.example.borutoandroid.presentation.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.borutoandroid.R
import com.example.todoappstefan2023.ui.theme.Purple500
import com.example.todoappstefan2023.ui.theme.Purple700

@Composable
fun SplashScreen(navHostController: NavHostController) {

    val scale = remember {
        Animatable(initialValue = 0f)
    }

    //LaunchedEffect runs only the first time of composable execuation.
    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 500,
                delayMillis = 250,
            )
        )
    }

    Splash(degrees = scale.value)
}

@Composable
fun Splash(degrees : Float) {

    val modifier: Modifier = if (isSystemInDarkTheme()) {
        Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Black,
                        Color.Black.copy(alpha = 0.8f)
                    )
                )
            )
            .fillMaxSize()
    } else {
        Modifier
            .background(brush = Brush.verticalGradient(colors = listOf(Purple700, Purple500)))
            .fillMaxSize()
    }

    Box(modifier = modifier.scale(degrees), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(R.string.app_logo)
        )
    }
}


@Preview
@Composable
fun SplashPreview() {
    Splash(0f)
}