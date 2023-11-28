package com.example.appratingsoft.ui.notas

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appratingsoft.Conexion.ApiConexion
import com.example.ratingsoft.data.Model.send.CursosSend
import com.example.ratingsoft.data.Model.send.NotasSend
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotasViewModel : ViewModel() {
    init {
        getAllContent()
    }

    private val _text = MutableLiveData<String>().apply {
        value = ""
    }
    val text: LiveData<String> = _text

    private val _contentData = MutableLiveData<List<NotasSend>>()
    val contentData: LiveData<List<NotasSend>> get() = _contentData

    private fun getAllContent() {
        CoroutineScope(Dispatchers.IO).launch {
            val apiGetContent = ApiConexion.getApiService().getNotas()

            apiGetContent.enqueue(object :
                Callback<List<NotasSend>> { // Cambiado a List<ContentResponse>
                override fun onResponse(
                    call: Call<List<NotasSend>>,
                    response: Response<List<NotasSend>>
                ) {
                    if (response.isSuccessful) {
                        val contentResponseList = response.body()
                        contentResponseList?.let {
                            _contentData.value = it
                        }
                    }
                }

                override fun onFailure(call: Call<List<NotasSend>>, t: Throwable) {
                    Log.e("Error content", t.toString())
                }
            })
        }
    }
}