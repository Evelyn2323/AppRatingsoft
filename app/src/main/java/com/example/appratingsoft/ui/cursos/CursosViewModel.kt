package com.example.appratingsoft.ui.cursos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appratingsoft.Conexion.ApiConexion
import com.example.ratingsoft.data.Model.send.CursosSend
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CursosViewModel : ViewModel() {
    // Inicializar la obtención de contenido al crear una instancia del ViewModel
    init {
        getAllContent()
    }

    // LiveData para almacenar el texto (puede que no necesites esto, depende de tus requerimientos)
    private val _text = MutableLiveData<String>().apply {
        value = ""
    }
    val text: LiveData<String> = _text

    // LiveData para almacenar la lista de datos de cursos
    private val _contentData = MutableLiveData<List<CursosSend>>()
    val contentData: LiveData<List<CursosSend>> get() = _contentData

    // Función para obtener todos los cursos desde la API
    private fun getAllContent() {
        // Usar un CoroutineScope para realizar operaciones en segundo plano
        CoroutineScope(Dispatchers.IO).launch {
            // Obtener el contenido de la API
            val apiGetContent = ApiConexion.getApiService().getCursos()

            apiGetContent.enqueue(object : Callback<List<CursosSend>> {
                override fun onResponse(
                    call: Call<List<CursosSend>>,
                    response: Response<List<CursosSend>>
                ) {
                    if (response.isSuccessful) {
                        // Si la respuesta es exitosa, obtener la lista de cursos y actualizar el LiveData
                        val contentResponseList = response.body()
                        contentResponseList?.let {
                            _contentData.value = it
                        }
                    }
                }

                override fun onFailure(call: Call<List<CursosSend>>, t: Throwable) {
                    // Manejar errores en la respuesta
                    Log.e("Error content", t.toString())
                }
            })
        }
    }
}
