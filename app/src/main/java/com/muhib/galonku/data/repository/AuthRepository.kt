package com.muhib.galonku.data.repository

import android.content.Context
import com.galonku.data.network.AuthResponse
import com.muhib.galonku.data.model.User
import com.muhib.galonku.data.network.ApiClient
import retrofit2.Response

class AuthRepository(private val context: Context) {

    private val apiService = ApiClient.getApiService(context)

    suspend fun register(user: User): Response<AuthResponse> {
        return apiService.registerUser(user)
    }
}