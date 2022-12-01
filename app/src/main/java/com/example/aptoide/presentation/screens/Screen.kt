package com.example.aptoide.presentation.screens

sealed class Screen(val route : String){
    object AppListingScreen : Screen("app_listing")
}
