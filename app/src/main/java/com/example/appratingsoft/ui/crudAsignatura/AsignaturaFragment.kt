package com.example.appratingsoft.ui.crudAsignatura

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appratingsoft.ClassImport.PopupAlert
import com.example.appratingsoft.Conexion.ApiConexion
import com.example.ratingsoft.data.Model.send.UserB
import com.example.appratingsoft.R
import com.example.appratingsoft.databinding.ActivityEditPerfilBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class AsignaturaFragment : Fragment()


 {

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

        val editPerfilModel = ViewModelProvider(this)[AsignaturaModel::class.java]

        editPerfilModel.user.observe(viewLifecycleOwner) {
            binding.username.text = it.nombreTipoAsignatura
            binding.Correo.text = it.descripcion
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

        val editPerfilModel = ViewModelProvider(this)[AsignaturaModel::class.java]
        val usuarioActual = editPerfilModel.user.value

        usuarioActual?.let {
            editText1.setText(usuarioActual.nombreTipoAsignatura)
            editText2.setText(usuarioActual.descripcion)
        }

        builder.setTitle("Ratingsoft")
            .setPositiveButton("Aceptar") { dialog, which ->
                val input1 = editText1.text.toString()
                val input2 = editText2.text.toString()

                //val userId = UserB.getT().toString()
                //editPerfilModel.updateProfile(, userId)
                //editPerfilModel.fetchUserProfile()
            }
            .setNegativeButton("Cancelar") { dialog, which ->
                toast.toastError(requireContext(), "Ratingsoft", "Operación cancelada")
            }

        val alertDialog = builder.create()
        alertDialog.show()
    }
}
