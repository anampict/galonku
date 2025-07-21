package com.muhib.galonku.data.model

data class Transaction (
    val _id: String? = null,
    val user_id: String,
    val product_id: String,
    val quantity: Int,
    val total_price: Int,
    val status: String = "panding",
    val transaction_date: String

)