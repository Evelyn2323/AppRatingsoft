package com.example.appratingsoft.ui.personas

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appratingsoft.Conexion.ApiConexion
import com.example.ratingsoft.data.Model.send.PersonasSend
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonasViewModel : ViewModel() {

    // Inicialización del ViewModel, llamando a la función getAllContent()
    init {
        getAllContent()
    }

    // LiveData para el texto, inicializado como cadena vacía
    private val _text = MutableLiveData<String>().apply {
        value = ""
    }
    val text: LiveData<String> = _text

    // LiveData para los datos de personas
    private val _contentData = MutableLiveData<List<PersonasSend>>()
    val contentData: LiveData<List<PersonasSend>> get() = _contentData

    // Función para obtener todos los datos de personas desde la API
    private fun getAllContent() {
        CoroutineScope(Dispatchers.IO).launch {
            val apiGetContent = ApiConexion.getApiService().getPersonas()

            apiGetContent.enqueue(object : Callback<List<PersonasSend>> {
                override fun onResponse(
                    call: Call<List<PersonasSend>>,
                    response: Response<List<PersonasSend>>
                ) {
                    if (response.isSuccessful) {
                        val contentResponseList = response.body()
                        contentResponseList?.let {
                            _contentData.value = it
                        }
                    }
                }

                override fun onFailure(call: Call<List<PersonasSend>>, t: Throwable) {
                    Log.e("Error contenido", t.toString())
                }
            })
        }
    }
}
