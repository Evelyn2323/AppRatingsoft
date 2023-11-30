package com.example.appratingsoft.ApiService

import com.example.appratingsoft.ui.crudTipoAsisgnatura.TipoAsignaturaCrud
import com.example.appratingsoft.ui.crudTipoAsisgnatura.TipoAsignaturaCrudResponse
import com.example.ratingsoft.data.Model.bring.loginBring
import com.example.ratingsoft.data.Model.send.CursosSend
import com.example.ratingsoft.data.Model.send.NotasSend
import com.example.ratingsoft.data.Model.send.PersonasSend
import com.example.ratingsoft.data.Model.send.User
import com.example.ratingsoft.data.Model.send.UserB
import com.example.ratingsoft.data.Model.send.loginSend
import com.example.ratingsoft.data.Model.send.tipoAsignaturasSend
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET("/api/tipoAsignaturas")
    fun obtenerAsignaturas(): Call<List<TipoAsignaturaCrud>>

    @POST("/api/tipoAsignaturas")
    fun agregarAsignatura(@Body asignatura: TipoAsignaturaCrud): Call<String>

    @PUT("/api/tipoAsignaturas/{id}")
    fun actualizarAsignatura(@Path("id") id: String, @Body asignatura: TipoAsignaturaCrud): Call<String>

    @DELETE("/api/tipoAsignaturas/{tipoAsignaturaId}")
    fun borrarAsignatura(@Path("id") id: String): Call<String>

    // Función de extensión para convertir Call<T> a Deferred<T>

    @POST("/api/login")
    fun loginUser(@Body loginRequest: loginBring): Call<loginSend>

    @GET("/api/users/{userId}")
    fun getUserProfile(@Path("userId") userId: String): Call<User>
    @PUT("/api/users/{userId}")
    fun updateProfile(@Body userRequest: UserB, @Path("userId") userId: String): Call<User>
    @DELETE("/api/users/{userId}")
    fun deleteprofile(@Path("userId") userId: String): Call<Void>

    @GET("/api/cursos")
    fun getCursos(): Call<List<CursosSend>>


//    @GET("/api/tipoAsignaturas/{tipoAsignaturaId}")
//    suspend fun obtenerAsignaturas(): Response<TipoAsignaturaCrudResponse>
//    @POST("/ruta/para/agregar/asignatura")
//    suspend fun agregarAsignatura(@Body asignatura: TipoAsignaturaCrud): Response<TipoAsignaturaCrudResponse>
//    @PUT("/api/tipoAsignaturas/{tipoAsignaturaId}")
//    suspend fun actualizarAsignatura(@Path("id") id: Int, @Body asignatura: TipoAsignaturaCrud): Response<TipoAsignaturaCrudResponse>
//
    @DELETE("/api/tipoAsignaturas/{tipoAsignaturaId}")
    fun borrarAsignatura(@Path("id") id: Int): Response<TipoAsignaturaCrudResponse>
    @GET("/api/tipoAsignaturas")
    fun getTipoAsignaturas(): Call<List<tipoAsignaturasSend>>
    @DELETE("/api/tipoAsignaturas/{tipoAsignaturaId}")
    fun deletetipoAsignaturas(@Path("tipoAsignaturaId") tipoAsignaturaId: String): Call<Void>
    @PUT("/api/tipoAsignaturas/{tipoAsignaturaId}")
    fun PUTtipoAsignaturas(@Path("tipoAsignaturaId") tipoAsignaturaId: String): Call<Void>

   @GET("/api/personas")
   fun getPersonas(): Call<List<PersonasSend>>

    @GET("/api/notas")
    fun getNotas(): Call<List<NotasSend>>
}
