package com.example.appratingsoft.ApiService

import com.example.ratingsoft.data.Model.bring.loginBring
import com.example.ratingsoft.data.Model.bring.tipoAsignaturasBring
import com.example.ratingsoft.data.Model.send.CursosSend
import com.example.ratingsoft.data.Model.send.NotasSend
import com.example.ratingsoft.data.Model.send.PersonasSend
import com.example.ratingsoft.data.Model.send.User
import com.example.ratingsoft.data.Model.send.UserB
import com.example.ratingsoft.data.Model.send.loginSend
import com.example.ratingsoft.data.Model.send.tipoAsignaturaSend
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @POST("/api/login")
    fun loginUser(@Body loginRequest: loginBring): Call<loginSend>

    @GET("/api/users/{userId}")
    fun getUserProfile(@Path("userId") userId: String): Call<User>
    @PUT("/api/users/{userId}")
    fun updateProfile(@Body userRequest: UserB, @Path("userId") userId: String): Call<User>
    @DELETE("/api/users/{userId}")
    fun deleteprofile(@Path("userId") userId: String): Call<Void>



    @GET("/api/tipoAsignaturas")
    fun getTipoAsignaturas(): Call<List<tipoAsignaturasBring>>
    @DELETE("/api/tipoAsignaturas/{tipoAsignaturaId}")
    fun deletetipoAsignaturas(@Path("tipoAsignaturaId") tipoAsignaturaId: String): Call<Void>
    @PUT("/api/tipoAsignaturas/{tipoAsignaturaId}")
    fun actuaizarTipoAsignatura(@Path("tipoAsignaturaId") tipoAsignaturaId: String): Call<Void>

    @GET("/api/cursos")
    fun getCursos(): Call<List<CursosSend>>

    @GET("/api/personas")
   fun getPersonas(): Call<List<PersonasSend>>

    @GET("/api/notas") 
    fun getNotas(): Call<List<NotasSend>>
}
