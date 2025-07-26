package com.muhib.galonku.pages.auth

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.muhib.galonku.pages.auth.login.LoginScreen
import com.muhib.galonku.pages.auth.ui.theme.GalonkuTheme
import androidx.lifecycle.ViewModelProvider
import com.muhib.galonku.data.viewmodel.AuthViewModel
import com.muhib.galonku.navigation.AppNavhost

class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Buat factory dan ViewModel secara manual
        val viewModelFactory = AuthViewModelFactory(applicationContext)
        val viewModel = ViewModelProvider(this, viewModelFactory)[AuthViewModel::class.java]
        setContent {
            GalonkuTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavhost(authViewModel = viewModel)
                }
            }
        }
    }
}



