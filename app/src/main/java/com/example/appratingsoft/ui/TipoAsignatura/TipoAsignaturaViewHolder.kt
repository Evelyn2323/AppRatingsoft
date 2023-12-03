package com.example.appratingsoft.ui.TipoAsignatura

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.ClassImport.PopupAlert
import com.example.appratingsoft.Conexion.ApiConexion
import com.example.appratingsoft.databinding.ItemTipoasignaturasBinding
import com.example.ratingsoft.data.Model.bring.tipoAsignaturasBring
import com.example.ratingsoft.data.Model.send.tipoAsignaturaSend
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TipoAsignaturaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // Binding para acceder a los elementos de la interfaz de usuario
    private val binding: ItemTipoasignaturasBinding = ItemTipoasignaturasBinding.bind(view)

    // Instancia de PopupAlert para mostrar alertas
    private val toast = PopupAlert()

    // Etiqueta de registro para la depuración
    private val TAG = "MyActivity"

    // Variable para almacenar el ID actual
    private var idabc = "0"

    // Función para renderizar los datos en la interfaz de usuario
    fun render(contentModel: tipoAsignaturasBring) {
        // Obtener el ID y establecer valores en los elementos de la interfaz de usuario
        binding.title.text = contentModel.nombreTipoAsignatura
        binding.description.text = contentModel.descripcion

        // Configurar el listener de clic
        clickListener(contentModel.id)
    }

    // Función para configurar el listener de clic en el botón eliminar
    private fun clickListener(id: Int) {
        binding.botonEliminar.setOnClickListener {
            // Registro de información sobre la eliminación
            Log.d(TAG, "ELIMINANDO... $id")

            // Llamada a la API para eliminar un tipo de asignatura
            val apiService = ApiConexion.getApiService()
            val deleteUserCall: Call<Void> = apiService.deletetipoAsignaturas(id.toString())

            // Manejo de la respuesta de la llamada a la API
            deleteUserCall.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        // Eliminación exitosa
                        Log.d("TipoAsignatura deletion", "TipoAsignatura deleted successfully")
                    } else {
                        // Manejar errores en la respuesta, si es necesario
                        Log.e(
                            "TipoAsignatura deletion",
                            "Failed to delete TipoAsignatura. Response code: ${response.code()}"
                        )
                        // Muestra una alerta de error
                        toast.toastError(itemView.context, "Error", "Error eliminando TipoAsignatura")
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    // Manejar errores en la solicitud, si es necesario
                    Log.e("TipoAsignatura deletion", "Error deleting TipoAsignatura", t)
                    // Muestra una alerta de error
                    toast.toastError(itemView.context, "Error", "Error eliminando TipoAsignatura")
                }
            })
        }
    }
}
