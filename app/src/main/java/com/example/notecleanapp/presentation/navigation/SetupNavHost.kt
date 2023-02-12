package com.example.notecleanapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.notecleanapp.presentation.screens.MainScreen
import com.example.notecleanapp.presentation.screens.add.AddScreen
import com.example.notecleanapp.presentation.screens.details.DetailsScreen

sealed class Screens(val route: String) {
    object MainScreen : Screens(route = "main_screen")
    object DetailsScreen : Screens(route = "details_screen")
    object AddScreen : Screens(route = "add_screen")
}

@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route
    ) {
        composable(route = Screens.MainScreen.route) {
            MainScreen(navController)
        }
        composable(
            route = Screens.DetailsScreen.route + "/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) {
            DetailsScreen(navController, it.arguments?.getString("id"))
        }
        composable(route = Screens.AddScreen.route) {
            AddScreen(navController)
        }
    }
}
