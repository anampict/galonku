package com.muhib.galonku.data.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhib.galonku.data.model.User
import com.muhib.galonku.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(private val context: Context) : ViewModel(){
    private val repository = AuthRepository(context)

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _registerSuccess = MutableStateFlow(false)
    val registerSuccess: StateFlow<Boolean> = _registerSuccess

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun register(user: User) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = repository.register(user)
                if (response.isSuccessful && response.body() != null) {
                    _registerSuccess.value = true
                } else {
                    _errorMessage.value = response.errorBody()?.string() ?: "Gagal mendaftar"
                }
            } catch (e: Exception) {
                _errorMessage.value = e.localizedMessage ?: "Terjadi kesalahan"
            } finally {
                _isLoading.value = false
            }
        }
    }

}