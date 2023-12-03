package com.example.appratingsoft.ui.TipoAsignatura

import android.content.Intent
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appratingsoft.Conexion.ApiConexion
import com.example.appratingsoft.EditTipoAsignaturaActivity
import com.example.ratingsoft.data.Model.bring.tipoAsignaturasBring
import com.example.ratingsoft.data.Model.send.tipoAsignaturaSend
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TipoAsignaturaViewModel : ViewModel() {

    // Inicialización: se llama al método getAllContent() cuando se crea una instancia del ViewModel
    init {
        getAllContent()
    }

    // LiveData para el texto
    private val _text = MutableLiveData<String>().apply {
        value = ""
    }
    val text: LiveData<String> = _text

    // LiveData para los datos de tipo asignatura
    private val _contentData = MutableLiveData<List<tipoAsignaturasBring>>()
    val contentData: LiveData<List<tipoAsignaturasBring>> get() = _contentData

    // Función para obtener todos los datos de tipo asignatura desde la API
    private fun getAllContent() {
        // Ejecutar en un hilo de fondo
        CoroutineScope(Dispatchers.IO).launch {
            // Llamada a la API para obtener los datos de tipo asignatura
            val apiGetContent = ApiConexion.getApiService().getTipoAsignaturas()

            apiGetContent.enqueue(object : Callback<List<tipoAsignaturasBring>> {
                override fun onResponse(
                    call: Call<List<tipoAsignaturasBring>>,
                    response: Response<List<tipoAsignaturasBring>>
                ) {
                    if (response.isSuccessful) {
                        // Obtener la lista de respuestas
                        val contentResponseList = response.body()
                        contentResponseList?.let {
                            // Actualizar el LiveData con la lista de datos de tipo asignatura
                            _contentData.value = it
                        }
                    }
                }

                override fun onFailure(call: Call<List<tipoAsignaturasBring>>, t: Throwable) {
                    // Manejar errores en caso de falla en la llamada
                    Log.e("Error content", t.toString())
                }
            })
        }
    }

}
