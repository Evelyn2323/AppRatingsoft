package com.example.appratingsoft.ui.perfil

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appratingsoft.Conexion.ApiConexion
import com.example.ratingsoft.data.Model.send.User
import com.example.ratingsoft.data.Model.send.UserAdmin
import com.example.ratingsoft.data.Model.send.UserB
import com.example.appratingsoft.ApiService.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class perfilViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }
    val text: LiveData<String> = _text

    private val userById = MutableLiveData<User>()
    val user: LiveData<User> get() = userById

    private val _deleteUserResult = MutableLiveData<Boolean>()
    val deleteUserResult: LiveData<Boolean> get() = _deleteUserResult

    private val _updateProfileResult = MutableLiveData<Boolean>()
    val updateProfileResult: LiveData<Boolean> get() = _updateProfileResult

    init {
        fetchUserProfile()
    }

    fun fetchUserProfile() {
        val userId = UserAdmin.getUserId()
       // getUserProfile(userId.toString())
    }

    fun deleteProfile(userId: String) {
        val apiService = ApiConexion.getApiService()

        val deleteProfileCall: Call<Void> = apiService.deleteprofile(userId)
        deleteProfileCall.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    _deleteUserResult.value = true
                } else {
                    _deleteUserResult.value = false
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                _deleteUserResult.value = false
            }
        })
    }

    fun updateProfile(userRequest: UserB, userId: String) {
        val apiService = ApiConexion.getApiService()

        val updateProfileCall: Call<User> = apiService.updateProfile(userRequest, userId)
        updateProfileCall.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    _updateProfileResult.value = true
                } else {
                    _updateProfileResult.value = false
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                _updateProfileResult.value = false
            }
        })
    }
}
