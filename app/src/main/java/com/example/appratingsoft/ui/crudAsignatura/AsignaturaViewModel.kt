package com.example.appratingsoft.ui.crudAsignatura

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appratingsoft.Conexion.ApiConexion
import com.example.ratingsoft.data.Model.bring.tipoAsignaturasBring
import com.example.ratingsoft.data.Model.send.tipoAsignaturaSend
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class AsignaturaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }
    val text: LiveData<String> = _text

    private val userById = MutableLiveData<tipoAsignaturaSend>()
    val user: LiveData<tipoAsignaturaSend> get() = userById



    private fun getAsignaturas() {
        val apiService = ApiConexion.getApiService()

        val asignaturas: Call<List<tipoAsignaturasBring>> = apiService.getTipoAsignaturas()
        asignaturas.enqueue(object : Callback<List<tipoAsignaturasBring>> {
            override fun onResponse(
                call: Call<List<tipoAsignaturasBring>>,
                response: Response<List<tipoAsignaturasBring>>
            ) {

                if (response.isSuccessful) {
                    Log.d("Asignaturas", response.body().toString())
                    //tipoasignatura = response.body().toList()
                }
            }

            override fun onFailure(call: Call<List<tipoAsignaturasBring>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}
