package com.example.buspassapplication

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.buspassapplication.screens.LoginScreen
import com.example.buspassapplication.screens.SignUpScreen

@ExperimentalMaterial3Api
@Composable
fun SetupNavGraph (
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Signup.route
    ) {
        composable(
            route= Screen.Signup.route
        ) {
            SignUpScreen(navHostController)
        }
        composable(
            route= Screen.Login.route
        ) {
            LoginScreen(navHostController)
        }
    }
}