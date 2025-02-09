package com.example.buspassapplication.graphs

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.MainNavigation

@ExperimentalMaterial3Api
@Composable
fun RootNavigationGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authenticationNavigationGraph(navController = navController)
        composable(route = Graph.MAIN) {
            MainNavigation(navController = rememberNavController())
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val MAIN = "home_graph"
}