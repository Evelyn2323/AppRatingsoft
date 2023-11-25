package com.example.appratingsoft.ApiService

import com.example.ratingsoft.data.Model.bring.loginBring
import com.example.ratingsoft.data.Model.send.CursosSend
import com.example.ratingsoft.data.Model.send.User
import com.example.ratingsoft.data.Model.send.loginSend
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("/api/login")
    fun loginUser(@Body loginRequest: loginBring): Call<loginSend>

    @GET("/api/users/{userId}")
    fun getUserProfile(@Path("userId") userId: String): Call<User>

    //abstract fun updateUserProfile(updatedUser: User): Call<User>
    //abstract fun getProduct(): Any

    @GET("/api/cursos")
    fun getCursos(): Call<List<CursosSend>>

}
