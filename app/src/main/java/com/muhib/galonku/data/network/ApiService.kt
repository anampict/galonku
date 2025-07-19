package com.galonku.data.network

import com.muhib.galonku.data.model.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response


data class RegisterRequest(
    val email: String,
    val role: String

)

interface ApiService {
    @POST("register")
    suspend fun registerUser(@Body request: RegisterRequest): Response<RegisterResponse>
}