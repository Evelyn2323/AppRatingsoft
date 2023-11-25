package com.example.ratingsoft.data.Model.send


data class loginSend (
    val message: String,
    val access_token: String,
    val token_type: String,
    val user: User
)
