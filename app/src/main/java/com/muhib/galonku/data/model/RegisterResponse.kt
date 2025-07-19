package com.muhib.galonku.data.model

data class RegisterResponse(
    val message: String,
    val user: User

)

data class User(
    val email: String,
    val role: String,
)