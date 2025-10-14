package com.example.navigation.presentation.navManager

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.presentation.views.DetailsView
import com.example.navigation.presentation.views.HomeView
import com.example.navigation.presentation.views.ProfileView

@Composable
fun NavManager(){
    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = "Home"
    ){
        composable("Home"){
            HomeView(navController)
        }

        composable("Details/{id}", arguments = listOf(
            navArgument(name="id"){
                type = NavType.LongType
            }
        )){
            val id = it.arguments?.getLong("id")?:0
            DetailsView(navController, id)
        }

        composable("Profile/{name}", arguments = listOf(
            navArgument(name="name"){
                type = NavType.StringType
            }
        )){
            val name = it.arguments?.getString("name")?:"XD"
            ProfileView(navController, name)
        }
    }
}