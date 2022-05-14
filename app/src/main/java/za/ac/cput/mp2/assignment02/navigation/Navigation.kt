package za.ac.cput.mp2.assignment02.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import za.ac.cput.mp2.assignment02.screens.AboutMeScreen
import za.ac.cput.mp2.assignment02.screens.WelcomeScreen
import za.ac.cput.mp2.assignment02.screens.ModuleScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route,
        builder ={
            composable(Screen.WelcomeScreen.route){ WelcomeScreen(navController = navController) }
            composable(Screen.AboutScreen.route){ AboutMeScreen(navController = navController) }
            composable(Screen.ModuleScreen.route){ ModuleScreen(navController = navController) }
        }
    )

}