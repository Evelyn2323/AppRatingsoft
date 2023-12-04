package com.example.appratingsoft

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.appratingsoft.ClassImport.PopupAlert
import com.example.appratingsoft.Conexion.ApiConexion
import com.example.appratingsoft.R
import com.example.appratingsoft.ui.TipoAsignatura.TipoAsignaturaViewHolder
import com.example.ratingsoft.data.Model.send.User
import com.example.ratingsoft.data.Model.send.UserAdmin
import com.example.ratingsoft.data.Model.send.tipoAsignaturaSend
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CrudPostActivity : AppCompatActivity() {

    private val toast = PopupAlert()

    private var user: User? = null
    private var userId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.asignatura_post)

        findViewById<Button>(R.id.btn_return).setOnClickListener {
            startActivity(Intent(this, TipoAsignaturaViewHolder::class.java))
        }
        getUserProfile(userId.toString())
        createContent()
    }

    private fun createContent() {
        userId = UserAdmin.getUserId()
        Log.d("CrudPostActivity", "User ID: $userId")

        getUserProfile(userId.toString())

        findViewById<Button>(R.id.btn_upload_content).setOnClickListener {
            // Obtener las vistas
            val nameTipoAsignaturaView = findViewById<EditText>(R.id.nameTipoAsignatura)
            val descriptionView = findViewById<EditText>(R.id.description)

            val nameTipoAsignatura = nameTipoAsignaturaView.text.toString()
            val description = descriptionView.text.toString()

            if (nameTipoAsignatura.isNotEmpty() && description.isNotEmpty()) {
                val asignaturaSend = tipoAsignaturaSend(
                    nameTipoAsignatura,
                    description
                )

                Log.d("CrudPostActivity", "asignaturaSend: $asignaturaSend")

                // Llamar a postContent sin multimediaPart
                lifecycleScope.launch {
                    try {
                        performNetworkRequest(asignaturaSend)

                        // Restablecer los campos después de la creación exitosa
                        nameTipoAsignaturaView.text.clear()
                        descriptionView.text.clear()

                    } catch (e: Exception) {
                        handleNetworkError(e)
                    }
                }
            } else {
                toast.toastWarning(
                    this,
                    "Campos incompletos",
                    "Completa los campos y selecciona una imagen"
                )
            }
        }
    }

    private suspend fun performNetworkRequest(contentRequest: tipoAsignaturaSend) {
        val apiService = ApiConexion.getApiService()

        val nameTipoAsignaturaRequestBody =
            contentRequest.nombreTipoAsignatura.toRequestBody("text/plain".toMediaTypeOrNull())

        val descriptionRequestBody =
            contentRequest.descripcion.toRequestBody("text/plain".toMediaTypeOrNull())

        val tipoAsignaturaRequest = tipoAsignaturaSend(
            nombreTipoAsignatura = contentRequest.nombreTipoAsignatura,
            descripcion = contentRequest.descripcion
        )

        apiService.createProduct(tipoAsignaturaRequest).enqueue(object : Callback<tipoAsignaturaSend> {
            override fun onResponse(call: Call<tipoAsignaturaSend>, response: Response<tipoAsignaturaSend>) {
                if (response.isSuccessful) {
                    val tipoAsignaturaResponse = response.body()
                    toast.toastSuccess(
                        this@CrudPostActivity,
                        "Exitoso",
                        "Asignatura creada exitosamente"
                    )

                    // Llamar a la función createContent después de obtener el usuario
                    createContent()

                    // Iniciar la actividad del fragmento deseado
                    setResult(-1, Intent())
                    finish() // Opcional: finalizar la actividad actual si no quieres volver a ella
                } else {
                    // Manejar el error de la respuesta
                    val errorBody = response.errorBody()?.string()
                    Log.e("CrudPostActivity", "Error response body: $errorBody")
                    toast.toastError(
                        this@CrudPostActivity,
                        "Error",
                        "Por favor, llena todos los campos"
                    )
                }
            }

            override fun onFailure(call: Call<tipoAsignaturaSend>, t: Throwable) {
                // Manejar la falla de la solicitud
                Log.e("CrudPostActivity", "Error en la solicitud: ${t.localizedMessage}")
                toast.toastError(
                    this@CrudPostActivity,
                    "Error",
                    "Hubo un error en la solicitud"
                )
            }
        })
    }

    private fun handleNetworkError(error: Exception) {
        // Manejar el error de la red aquí
        Log.e("CrudPostActivity", "Error de red: ${error.localizedMessage}")
        toast.toastError(
            this@CrudPostActivity,
            "Error",
            "Hubo un error en la solicitud"
        )
    }

    private fun getUserProfile(userId: String) {
        val apiService = ApiConexion.getApiService()

        val userProfileCall: Call<User> = apiService.getUserProfile(userId)
        userProfileCall.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    user = response.body()
                    user?.let {
                        Log.d("CrudPostActivity", "User: $user")
                        createContent() // Llamar a la función createContent después de obtener el usuario
                    } ?: run {
                        Log.e("CrudPostActivity", "User is null")
                    }
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("Error user", t.toString())
            }
        })
    }
}
