package com.example.matule.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun HomeScreen(
    navController: NavHostController,
    inAbout: () -> Unit,
    inLogin: () -> Unit,
    inCart: () -> Unit,
    inAboutOrder: () -> Unit
) {

    NavHost(
        navController,
        startDestination = Screens.Home.route,
        builder = {
            composable(Screens.Home.route) {
                HomePage() {
                    inAbout()
                }
            }
            composable(Screens.Favorite.route) {
                FavoritePage()
            }
            composable(Screens.Account.route) {
                ProfilePage(
                    onLogin = {
                        inLogin()
                    },
                    navController = navController,
                    inCart = {
                        inCart()
                    }
                )
            }
            composable(Screens.Notification.route) {
                NotificationPage()
            }
            composable(Screens.Orders.route) {
                OrdersScreen(
                    inAbout = {
                        inAboutOrder()
                    },
                    onBack = {
                        navController.navigate(Screens.Account.route)
                    }
                )
            }
        }
    )
}