package com.example.appratingsoft.ui.TipoAsignatura

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.ClassImport.PopupAlert
import com.example.appratingsoft.Conexion.ApiConexion
import com.example.appratingsoft.EditTipoAsignaturaActivity

import com.example.appratingsoft.databinding.ItemTipoasignaturasBinding
import com.example.appratingsoft.tipoAsignatura_activity
import com.example.ratingsoft.data.Model.send.tipoAsignaturasSend
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TipoAsignaturaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding: ItemTipoasignaturasBinding = ItemTipoasignaturasBinding.bind(view)
    private val toast = PopupAlert()
    private val TAG = "MyActivity"
    private var idabc = "0"


    fun render(contentModel: tipoAsignaturasSend) {
        idabc = contentModel.id;
        binding.title.text = contentModel.id
        binding.title.text = contentModel.nombreTipoAsignatura
        binding.description.text = contentModel.descripcion

        clickListener()
//        clickListener2()
    }

    private fun clickListener() {
        binding.botonEliminar.setOnClickListener {
            Log.d(TAG, "ELIMINANDO..." + idabc)

            val apiGetContent = ApiConexion.getApiService().deletetipoAsignaturas(idabc)

            val apiService = ApiConexion.getApiService()

            val deleteUserCall: Call<Void> = apiService.deletetipoAsignaturas(idabc)
            deleteUserCall.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        // Eliminación exitosa
                        Log.d("User deletion", "User deleted successfully")
                        //_deleteUserResult.value = true
                    } else {
                        // Manejar errores en la respuesta, si es necesario
                        Log.e(
                            "User deletion",
                            "Failed to delete user. Response code: ${response.code()}"
                        )
                        // _deleteUserResult.value = false
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    // Manejar errores en la solicitud, si es necesario
                    Log.e("User deletion", "Error deleting user", t)
                    // _deleteUserResult.value = false
                }
            })
        }
    }

//    private fun clickListener2() {
//        binding.botonEditar.setOnClickListener {
//            Log.d(TAG, "EDITANDO... $idabc")
//
//            // Aquí deberías construir un objeto TipoAsignaturaSend con los datos actuales
//            val tipoAsignaturaSend = tipoAsignaturasSend(
//                idabc,
//                binding.title.text.toString(),
//                binding.description.text.toString()
//            )
//
//            // Obtén el contexto desde la vista
//            val context = binding.root.context
//
//            // Abre la pantalla de edición y pasa el objeto tipoAsignaturaSend
//            val intent = Intent(context, EditTipoAsignaturaActivity::class.java)
//            intent.putExtra("TIPO_ASIGNATURA", tipoAsignaturaSend)
//            context.startActivity(intent)
//        }
//    }
}

