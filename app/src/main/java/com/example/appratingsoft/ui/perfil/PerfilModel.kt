package com.example.appratingsoft.ui.perfil

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appratingsoft.ApiService.ApiService
import com.example.appratingsoft.Conexion.ApiConexion
import com.example.ratingsoft.data.Model.send.User
import com.example.ratingsoft.data.Model.send.UserAdmin
import com.example.ratingsoft.data.Model.send.UserB
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PerfilModel : ViewModel() {

    // Inicialización al obtener el ID del usuario al inicio
    init {
        val userId = UserAdmin.getUserId()
        Log.e("IDUSER", "${userId}")
        getUserProfile(userId.toString())
    }

    // LiveData para texto (puede ser eliminado si no se utiliza)
    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text

    // LiveData para los datos del usuario
    private val userById = MutableLiveData<User>()
    val user: LiveData<User> get() = userById

    // Función para obtener y actualizar los datos del perfil del usuario
    fun fetchUserProfile() {
        val userId = UserAdmin.getUserId()
        getUserProfile(userId.toString())
    }

    // Función para obtener los datos del perfil del usuario por ID
    private fun getUserProfile(userId: String) {
        val apiService = ApiConexion.getApiService()

        val userProfileCall: Call<User> = apiService.getUserProfile(userId)
        userProfileCall.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user = response.body()
                    user?.let {
                        userById.value = it
                    }
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("Error user", t.toString())
            }
        })
    }

    // LiveData para el resultado de eliminación de usuario
    private val _deleteUserResult = MutableLiveData<Boolean>()
    val deleteUserResult: LiveData<Boolean> get() = _deleteUserResult

    // Función para eliminar el perfil del usuario
    fun deleteUser(userId: String) {
        val apiService = ApiConexion.getApiService()

        val deleteUserCall: Call<Void> = apiService.deleteprofile(userId)
        deleteUserCall.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    // Eliminación exitosa
                    Log.d("User deletion", "User deleted successfully")
                    _deleteUserResult.value = true
                } else {
                    // Manejar errores en la respuesta, si es necesario
                    Log.e(
                        "User deletion",
                        "Failed to delete user. Response code: ${response.code()}"
                    )
                    _deleteUserResult.value = false
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                // Manejar errores en la solicitud, si es necesario
                Log.e("User deletion", "Error deleting user", t)
                _deleteUserResult.value = false
            }
        })
    }

    // LiveData para el resultado de actualización de perfil
    private val _updateProfileResult = MutableLiveData<Boolean>()
    val updateProfileResult: LiveData<Boolean> get() = _updateProfileResult

    // Función para actualizar el perfil del usuario
    fun updateProfile(userRequest: UserB, userId: String) {
        val apiService = ApiConexion.getApiService()

        val userProfileCall: Call<User> = apiService.updateProfile(userRequest, userId)
        userProfileCall.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    _updateProfileResult.value = true
                } else {
                    _updateProfileResult.value = false
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
//                Log.e("Error de actualización de perfil", "Error actualizando el perfil del usuario", t)
                _updateProfileResult.value = false
            }
        })
    }
}
