package com.muhib.galonku.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.muhib.galonku.AppScreen
import com.muhib.galonku.data.viewmodel.AuthViewModel
import com.muhib.galonku.pages.auth.login.LoginScreen
import com.muhib.galonku.pages.auth.register.RegisterScreen
import com.muhib.galonku.pages.home.HomeScreen

@Composable
fun AppNavhost(authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route
    ) {
        composable(AppScreen.Home.route) { HomeScreen(navController) }
        composable(AppScreen.Register.route) { RegisterScreen(viewModel = authViewModel,navController) }
        composable(AppScreen.Login.route) { LoginScreen(navController,viewModel = authViewModel) }

    }

}