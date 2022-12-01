package com.example.aptoide.presentation.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aptoide.presentation.screens.AppListingScreen
import com.example.aptoide.presentation.screens.Screen

@Composable
fun Navigations() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.AppListingScreen.route
    ) {
        composable(route = Screen.AppListingScreen.route) {
            AppListingScreen(navController)
        }
    }
}