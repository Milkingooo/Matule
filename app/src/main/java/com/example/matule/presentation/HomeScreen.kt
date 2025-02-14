package com.example.matule.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavHostController,
               inAbout: () -> Unit){

    NavHost(
        navController,
        startDestination = Screens.Home.route,
        builder = {
            composable(Screens.Home.route) {
                HomePage(){
                    inAbout()
                }
            }
            composable(Screens.Favorite.route) {
                FavoritePage()
            }
            composable(Screens.Account.route) {
                ProfilePage()
            }
            composable(Screens.Notification.route) {
                NotificationPage()
            }

        })
}