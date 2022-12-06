package com.example.aptoide.presentation.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.aptoide.presentation.screens.AppDetailScreen
import com.example.aptoide.presentation.screens.AppListingScreen
import com.example.aptoide.presentation.screens.Screen

@Composable
fun Navigation() {

    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = Screen.AppListingScreen.route
    ) {
        composable(route = Screen.AppListingScreen.route) {
            AppListingScreen(navController)

        }
        composable(route = Screen.AppDetailScreen.route + "/{id}",
            ///arguments = listOf(navArgument("id") { defaultValue = ("123654789").toLong() })
        ) { backStackEntry ->
            val id = backStackEntry.arguments!!.getString("id")?.toLong() ?: 125666666
            val downloads = backStackEntry.arguments!!.getString("size")?.toLong() ?: 125666667
            AppDetailScreen(id = id, navController = navController, downloads = downloads)
        }
    }
}