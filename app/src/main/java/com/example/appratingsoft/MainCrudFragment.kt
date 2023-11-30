//package com.example.appratingsoft.a
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.EditText
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.appratingsoft.R
//import com.example.appratingsoft.RetrofitClient
//import com.example.appratingsoft.databinding.FragmentMainCrudBinding
//import com.example.appratingsoft.ui.crudTipoAsisgnatura.TipoAsignaturaCrud
//import com.example.appratingsoft.ui.crudTipoAsisgnatura.TipoAsignaturaCrudAdapter
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//class MainCrudFragment : Fragment() {
//
//    private lateinit var etNombreTipoAsignatura: EditText
//    private lateinit var etDescripcion: EditText
//    private lateinit var btnAddUpdate: Button
//    private lateinit var rvAsignatura: RecyclerView
//
//    private var _binding: FragmentMainCrudBinding? = null
//    private val binding get() = _binding!!
//
//
//    private lateinit var tipoAsignaturaList: MutableList<TipoAsignaturaCrud>
//    private lateinit var tipoAsignaturaAdapter: TipoAsignaturaCrudAdapter
//    var tipoAsignaturaCrud = TipoAsignaturaCrud(   "", "", "")
//
//    var isEditing = false
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(R.layout.fragment_main_crud, container, false)
//        _binding = FragmentMainCrudBinding.inflate(inflater, container, false)
//        val view = binding.root
//
//        etNombreTipoAsignatura = view.findViewById(R.id.etNombreTipoAsignatura)
//        etDescripcion = view.findViewById(R.id.etDescripcion)
//        btnAddUpdate = view.findViewById(R.id.btnAddUpdate)
//        rvAsignatura = view.findViewById(R.id.rvAsignatura)
//
//        tipoAsignaturaList = mutableListOf()
//        tipoAsignaturaAdapter = TipoAsignaturaCrudAdapter(tipoAsignaturaList)
//        rvAsignatura.layoutManager = LinearLayoutManager(requireContext())
//        rvAsignatura.adapter = tipoAsignaturaAdapter
//
//        btnAddUpdate.setOnClickListener {
//            // Lógica para agregar o actualizar TipoAsignatura
//        }
//        binding.btnAddUpdate.setOnClickListener {
//            val isValid = validateFields()
//            if (isValid) {
//                if (!isEditing) {
//                    addTipoAsignatura()
//                } else {
//                    updateTipoAsignatura()
//                }
//            } else {
//                // Muestra un mensaje de error si los campos no son válidos
//            }
//        }
//
//        return view
//    }
//
//    private fun validateFields(): Boolean {
//        return !(binding.etNombreTipoAsignatura.text.isNullOrEmpty() || binding.etDescripcion.text.isNullOrEmpty())
//    }
//
//    private fun addTipoAsignatura() {
//        tipoAsignaturaCrud.id = "" // Debes generar el ID o ajustarlo según tu lógica
//        tipoAsignaturaCrud.nombreTipoAsignatura = binding.etNombreTipoAsignatura.text.toString()
//        tipoAsignaturaCrud.descripcion = binding.etDescripcion.text.toString()
//
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val response = RetrofitClient.apiService.agregarAsignatura(tipoAsignaturaCrud).await()
//                if (response.isSuccessful) {
//                    // Muestra un mensaje de éxito o realiza acciones adicionales
//                    activity?.runOnUiThread {
//                        // Actualiza la lista u otras acciones necesarias
//                    }
//                } else {
//                    // Muestra un mensaje de error
//                }
//            } catch (e: Exception) {
//                // Maneja las excepciones, por ejemplo, problemas de red
//            }
//        }
//    }
//
//    private fun updateTipoAsignatura() {
//        tipoAsignaturaCrud.nombreTipoAsignatura = binding.etNombreTipoAsignatura.text.toString()
//        tipoAsignaturaCrud.descripcion = binding.etDescripcion.text.toString()
//
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val response = RetrofitClient.apiService.actualizarAsignatura(tipoAsignaturaCrud.id, tipoAsignaturaCrud).await()
//                if (response.isSuccessful) {
//                    // Muestra un mensaje de éxito o realiza acciones adicionales
//                    activity?.runOnUiThread {
//                        // Actualiza la lista u otras acciones necesarias
//                    }
//                } else {
//                    // Muestra un mensaje de error
//                }
//            } catch (e: Exception) {
//                // Maneja las excepciones, por ejemplo, problemas de red
//            }
//        }
//    }
//    return view
//    }
//
