package com.muhib.galonku

import android.os.Bundle
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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.muhib.galonku.data.viewmodel.AuthViewModel
import com.muhib.galonku.navigation.AppNavhost
import com.muhib.galonku.pages.auth.AuthViewModelFactory
import com.muhib.galonku.pages.auth.login.LoginScreen
import com.muhib.galonku.pages.auth.register.RegisterScreen
import com.muhib.galonku.ui.theme.GalonkuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val factory = AuthViewModelFactory(applicationContext)
        val authViewModel = ViewModelProvider(this, factory)[AuthViewModel::class.java]
        setContent {
            GalonkuTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavhost(authViewModel = authViewModel)

                }
            }
        }
    }
}
