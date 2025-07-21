package com.muhib.galonku.data.model

data class User(
    val _id: String,
    val name: String,
    val email: String,
    val password: String? = null,
    val role: String = "user", // default user/admin

)