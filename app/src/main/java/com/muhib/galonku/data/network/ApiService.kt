package com.galonku.data.network

import com.muhib.galonku.data.model.Product
import com.muhib.galonku.data.model.Transaction
import com.muhib.galonku.data.model.User
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


data class AuthResponse(
    val message: String,
    val token: String? = null,
    val user: User

)

data class UserResponse(
    val id: String,
    val email: String,
    val role: String
)

data class ProductResponse(
    val message: String,
    val products: List<Product>
)

data class TransactionListResponse(
    val message: String,
    val transactions: List<Transaction>
)

data class GenericResponse(
    val message: String
)

data class TransactionRequest(
    val user_id: String,
    val product_id: String,
    val quantity: Int
)

data class StatusUpdateRequest(
    val status: String
)


interface ApiService {
    //register user
    @POST("api/register")
    suspend fun registerUser(@Body user: User): Response<AuthResponse>

    //login user
    @POST("api/login")
    suspend fun loginUser(@Body user: User): Response<AuthResponse>

    //get all product
    @GET("api/products")
    suspend fun getAllProducts(): Response<ProductResponse>

    //create transaction
    @POST("api/transactions")
    suspend fun createTransaction(@Body transaction: TransactionRequest): Response<GenericResponse>

    //get semua transaksi (admin)
    @GET("api/transactions")
    suspend fun getAllTransactions(): Response<TransactionListResponse>

    //get user transaksi
    @GET("api/transactions/user/{user_id}")
    suspend fun getTransactionsByUser(@Path("user_id") userId: String): Response<TransactionListResponse>

    //update status transaksi
    @POST("api/transactions/{id}/status")
    suspend fun updateTransactionStatus(
        @Path("id") transactionId: String,
        @Body statusUpdate: StatusUpdateRequest
    ): Response<GenericResponse>


}