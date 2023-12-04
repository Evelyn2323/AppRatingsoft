package com.example.appratingsoft

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.appratingsoft.ClassImport.PopupAlert
import com.example.appratingsoft.Conexion.ApiConexion
import com.example.appratingsoft.databinding.ActivityEditPerfilBinding
import com.example.appratingsoft.databinding.ActivityTipoAsignaturasBinding
import com.example.ratingsoft.data.Model.bring.tipoAsignaturasBring
import com.example.ratingsoft.data.Model.send.tipoAsignaturaSend
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Integer.parseInt

class EditTipoAsignaturaActivity : AppCompatActivity() {

    private val toast = PopupAlert()

    private var tipoAsignaturaId = 0

    private lateinit var binding: ActivityTipoAsignaturasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipoAsignaturasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getIdTipoAsignacion()

        getTipoAsignatura(tipoAsignaturaId.toString())

        sendContentToUpdate()

    }

    private fun getIdTipoAsignacion() {
        val intent = intent
        if (intent != null && intent.hasExtra("TIPOASIGNATURA_ID")) {
            val tipoAsignaturaIdString = intent.getIntExtra("TIPOASIGNATURA_ID", 0)
            if (tipoAsignaturaIdString != null) {
                try {
                    tipoAsignaturaId = tipoAsignaturaIdString
                    Log.e("TIPO", "${tipoAsignaturaId}")
                } catch (e: NumberFormatException) {
                    toast.toastError(
                        this,
                        "Error",
                        "No se pudo convertir TIPOASIGNATURA_ID a entero"
                    )
                }
            } else {
                toast.toastError(this, "Error", "El valor de TIPOASIGNATURA_ID es nulo")
            }
        } else {
            toast.toastError(
                this,
                "Error",
                "Ups!, ha ocurrido un error inesperado, inténtalo de nuevo o más tarde"
            )
        }
    }

    private fun getTipoAsignatura(idTipoAsignatura: String) {
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

    private fun sendContentToUpdate() {

        binding.updateTipoAsignatura.setOnClickListener {

            val title = binding.nameTipoAsignatura.text.toString()

            val description = binding.description.text.toString()

            if (title.isNotEmpty() && description.isNotEmpty()) {

                // Object of content
                val tipoAsignaturaRequest = tipoAsignaturaSend( title, description)

                // Llamar a la función para enviar los datos al servidor
                if (tipoAsignaturaRequest != null) {
                    Log.e("CONTENT", "$tipoAsignaturaRequest")
                    updateContent(tipoAsignaturaRequest)
                }

            } else {

                toast.toastWarning(this, "Campos incompletos", "Completa los campos y selecciona una imagen")

            }
        }
    }

    private fun updateContent(tipoAsignaturaRequest: tipoAsignaturaSend) {

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val apiService = ApiConexion.getApiService()

                val requestBody = tipoAsignaturaSend(
                    nombreTipoAsignatura = tipoAsignaturaRequest.nombreTipoAsignatura,
                    descripcion = tipoAsignaturaRequest.descripcion
                )

                val response = requestBody.let {
                    apiService.actualizarTipoAsignatura(
                        tipoAsignaturaId = tipoAsignaturaId.toString(),
                        body = requestBody
                    ).execute()
                }

                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        // Solicitud exitosa
                        toast.toastSuccess(
                            this@EditTipoAsignaturaActivity,
                            "Ratingsoft",
                            "Contenido actualizado exitosamente, se revisará lo más pronto posible!!! 😊😊😊😊😊"
                        )
                        startActivity(Intent(applicationContext, MainActivity::class.java))
                    } else {
                        // Manejar error
                        toast.toastError(
                            this@EditTipoAsignaturaActivity,
                            "Error",
                            "Por favor, llena todos los campos"
                        )
                    }
                }
            } catch (e: Exception) {
                // Manejar excepciones
                withContext(Dispatchers.Main) {
                    toast.toastError(
                        this@EditTipoAsignaturaActivity,
                        "Error",
                        "e " + e.localizedMessage
                    )
                }
            }
        }
    }



}
