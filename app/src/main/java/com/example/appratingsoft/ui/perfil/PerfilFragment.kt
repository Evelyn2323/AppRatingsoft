package com.example.appratingsoft.ui.perfil

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.appratingsoft.ApiService.ApiService
import com.example.appratingsoft.ClassImport.PopupAlert
import com.example.appratingsoft.Conexion.ApiConexion
import com.example.ratingsoft.data.Model.send.UserAdmin
import com.example.ratingsoft.data.Model.send.UserB
import com.example.appratingsoft.R
import com.example.appratingsoft.databinding.ActivityEditPerfilBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PerfilFragment : Fragment() {

    private var _binding: ActivityEditPerfilBinding? = null
    private val toast = PopupAlert()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityEditPerfilBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val editPerfilModel = ViewModelProvider(this)[PerfilModel::class.java]

        // Data of user
        editPerfilModel.user.observe(viewLifecycleOwner) { newData ->

            binding.username.text = newData.name
            binding.Correo.text = newData.email
        }

        binding.edit.setOnClickListener {
            mostrarDialogo()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun mostrarDialogo() {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = LayoutInflater.from(requireContext())
        val dialogoView = inflater.inflate(R.layout.dialog_input, null)
        builder.setView(dialogoView)

        val editText1 = dialogoView.findViewById<EditText>(R.id.username)
        val editText2 = dialogoView.findViewById<EditText>(R.id.Correo)

        // Obtén el modelo actual del usuario desde el ViewModel
        val editPerfilModel = ViewModelProvider(this)[perfilViewModel::class.java]
        val usuarioActual = editPerfilModel.user.value

        // Si el usuario actual no es nulo, establece los valores en los campos del diálogo
        usuarioActual?.let {
            editText1.setText(it.name)
            editText2.setText(it.email)
        }

        builder.setTitle("Ratingsoft")
            .setPositiveButton("Aceptar") { dialog, which ->
                val input1 = editText1.text.toString()
                val input2 = editText2.text.toString()

                // Obtén el ID del usuario de alguna manera (dependiendo de tu implementación)
                val userId = UserAdmin.getUserId().toString() // Convierte a String

                // Llamas a la función para actualizar el perfil con el ID del usuario convertido a String
                editPerfilModel.updateProfile(UserB(input1, input2,), userId)

                // Después de actualizar el perfil, llama a la función para volver a obtener el perfil actualizado
                editPerfilModel.fetchUserProfile()
            }
            .setNegativeButton("Cancelar") { dialog, which ->
                // Muestra una alerta de error o un Toast indicando que la operación fue cancelada
                toast.toastError(requireContext(), "Ratingsoft", "Operación cancelada")
            }

        val alertDialog = builder.create()
        alertDialog.show()
    }
}
