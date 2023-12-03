package com.example.appratingsoft

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appratingsoft.ClassImport.PopupAlert
import com.example.appratingsoft.Conexion.ApiConexion
import com.example.appratingsoft.databinding.ActivityEditPerfilBinding
import com.example.appratingsoft.databinding.ActivityTipoAsignaturasBinding
import com.example.ratingsoft.data.Model.bring.tipoAsignaturasBring
import com.example.ratingsoft.data.Model.send.tipoAsignaturaSend
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditTipoAsignaturaActivity : AppCompatActivity() {

    private val toast = PopupAlert()

    private lateinit var binding: ActivityTipoAsignaturasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipoAsignaturasBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }


    private fun getTipoAsignatura(idTipoAsignatura: String) { // esta es para actualizar
        val apiService = ApiConexion.getApiService()

        val tipoAsignatura: Call<tipoAsignaturasBring> = apiService.getTipoAsignaturaById(idTipoAsignatura)
        tipoAsignatura.enqueue(object : Callback<tipoAsignaturasBring> {
            override fun onResponse(call: Call<tipoAsignaturasBring>, response: Response<tipoAsignaturasBring>) {
                if (response.isSuccessful) {
                    val tipoAsignatura = response.body()
                    tipoAsignatura?.let {
                        binding.nameTipoAsignatura.setText(it.nombreTipoAsignatura)
                        binding.description.setText(it.descripcion)
                    }
                }
            }

            override fun onFailure(call: Call<tipoAsignaturasBring>, t: Throwable) {
                toast.toastError(this@EditTipoAsignaturaActivity, "Conexión", "Error de conexión")
            }
        })
    }

}
