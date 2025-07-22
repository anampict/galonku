package com.muhib.galonku

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class AppScreen(@StringRes val title: Int, @DrawableRes val icon: Int, val route: String) {
    object Home : AppScreen(R.string.app_name, R.drawable.ic_launcher_background, "home")
    object Register : AppScreen(R.string.app_name, R.drawable.ic_launcher_background, "register")
    object Login : AppScreen(R.string.app_name, R.drawable.ic_launcher_background, "login")




}