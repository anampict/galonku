package com.muhib.galonku.pages.auth.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.muhib.galonku.AppScreen
import com.muhib.galonku.R
import com.muhib.galonku.commond.poppinsfamily
import com.muhib.galonku.data.model.User
import com.muhib.galonku.data.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: AuthViewModel
) {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val isLoading by viewModel.isLoading.collectAsState()
    val loginSuccess by viewModel.loginSuccess.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    LaunchedEffect(loginSuccess) {
        if (loginSuccess) {
            Toast.makeText(context, "Login berhasil", Toast.LENGTH_SHORT).show()
            navController.navigate(AppScreen.Home.route) {
                popUpTo(AppScreen.Login.route) { inclusive = true }
            }
            viewModel.resetLoginSuccess()

        }

    }

    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xffE4EAF9)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 26.dp, end = 26.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(65.dp))
                Image(
                    painter = painterResource(id = R.drawable.login),
                    contentDescription = "login",
                    contentScale = ContentScale.FillBounds
                )
                Spacer(Modifier.height(59.dp))

                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        "Login",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppinsfamily,
                        color = Color.Black
                    )

                    Text(
                        "Silahkan Login Ke Akun Anda",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppinsfamily,
                        color = Color(0xff6E6E6E)
                    )
                }


                Spacer(modifier = Modifier.height(16.dp))

                // Email TextField
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email", color = Color(0xff6E6E6E)) }, textStyle = TextStyle(
                        fontFamily = poppinsfamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = Color.Black
                    ),
                    leadingIcon = {
                        Icon(
                            Icons.Default.Email,
                            contentDescription = "Email Icon",
                            tint = Color(0xff545454)
                        )
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .width(360.dp)
                        .padding(bottom = 16.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent

                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Password TextField
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password", color = Color(0xff6E6E6E)) }, textStyle = TextStyle(
                        fontFamily = poppinsfamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = Color.Black
                    ),
                    leadingIcon = {
                        Icon(
                            Icons.Default.Lock,
                            contentDescription = "Password Icon",
                            tint = Color(0xff545454)
                        )
                    },
                    trailingIcon = {
                        val image =
                            if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = image,
                                contentDescription = null,
                                tint = Color(0xff545454)
                            )
                        }
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    singleLine = true,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .width(360.dp)
                        .padding(bottom = 8.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,

                        )


                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        val user = User(email = email, password = password)
                        viewModel.login(user)
                    },
                    enabled = !isLoading,
                    modifier = Modifier
                        .width(249.dp)
                        .height(53.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xff367CFF)),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            strokeWidth = 2.dp,
                            color = Color.White
                        )
                    } else {
                        Text(
                            "Login", fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppinsfamily,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                TextButton(onClick = { navController.navigate(AppScreen.Register.route) }) {
                    Column(
                        modifier = Modifier.height(60.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Belum punya akun ?",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppinsfamily,
                            color = Color(0xff6E6E6E)
                        )

                        Text(
                            "Daftar",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppinsfamily,
                            color = Color(0xff367CFF)
                        )

                    }

                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController(), viewModel = viewModel())
}
