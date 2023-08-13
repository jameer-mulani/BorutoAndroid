package com.example.borutoandroid.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.borutoandroid.presentation.screens.splash.SplashScreen
import com.example.borutoandroid.util.Constants

@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Splash.route
    ) {

        composable(route = Screen.Splash.route) {
            SplashScreen(navHostController = navHostController)
        }

        composable(route = Screen.Welcome.route) {

        }

        composable(route = Screen.Search.route) {

        }

        composable(route = Screen.Home.route) {

        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(Constants.DETAILS_SCREEN_ARG_KEY) {
                type = NavType.IntType
            })
        ) {

        }

    }
}