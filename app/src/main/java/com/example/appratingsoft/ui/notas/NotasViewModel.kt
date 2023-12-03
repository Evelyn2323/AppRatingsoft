package com.example.appratingsoft.ui.notas

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appratingsoft.Conexion.ApiConexion
import com.example.ratingsoft.data.Model.send.NotasSend
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotasViewModel : ViewModel() {

    // Inicializar la obtención de todos los contenidos al crear una instancia del ViewModel
    init {
        getAllContent()
    }

    // LiveData para almacenar el texto (puedes ajustar según tus necesidades)
    private val _text = MutableLiveData<String>().apply {
        value = ""
    }
    val text: LiveData<String> = _text

    // LiveData para almacenar la lista de datos de notas
    private val _contentData = MutableLiveData<List<NotasSend>>()
    val contentData: LiveData<List<NotasSend>> get() = _contentData

    // Función para obtener todos los contenidos de notas
    private fun getAllContent() {
        CoroutineScope(Dispatchers.IO).launch {
            // Llamada a la API para obtener la lista de notas
            val apiGetContent = ApiConexion.getApiService().getNotas()

            // Manejo de la respuesta de la llamada a la API
            apiGetContent.enqueue(object : Callback<List<NotasSend>> {
                override fun onResponse(
                    call: Call<List<NotasSend>>,
                    response: Response<List<NotasSend>>
                ) {
                    if (response.isSuccessful) {
                        // Obtener la lista de respuestas de notas
                        val contentResponseList = response.body()
                        contentResponseList?.let {
                            // Actualizar el LiveData con la nueva lista de notas
                            _contentData.value = it
                        }
                    }
                }

                override fun onFailure(call: Call<List<NotasSend>>, t: Throwable) {
                    // Manejar errores en caso de fallo en la llamada a la API
                    Log.e("Error content", t.toString())
                }
            })
        }
    }
}
