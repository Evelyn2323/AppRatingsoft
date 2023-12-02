//package com.example.appratingsoft.crudTipoAsisgnatura
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.appratingsoft.databinding.FragmentMainCrudBinding
//
//
//
//class CrudFragment : Fragment(), NombresAdapter.OnItemClickListener {
//
//    private lateinit var binding: FragmentMainCrudBinding  // Usa la clase de enlace correcta
//    private lateinit var mAdapter: NombresAdapter
//    private var isEditar = false
//    private var posicion = -1
//    private val ViewBinding= rvList
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentMainCrudBinding.inflate(inflater, container, false)  // Usa el enlace correcto
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        mAdapter = NombresAdapter(this)
//        binding.rvList.layoutManager = LinearLayoutManager(requireContext())
//        binding.rvList.adapter = mAdapter
//
//        binding.b.setOnClickListener {
//            if (!isEditar) {
//                // Asumiendo que tu adapter tiene un método addItem
//                mAdapter.addItem(Nombre(binding.etNombreTipoAsignatura.text.toString().trim()))
//                binding.etNome.setText("")
//            } else {
//                // Asumiendo que tu adapter tiene un método editItem
//                mAdapter.editItem(posicion, binding.etNombre.text.toString())
//                binding.etNombre.setText("")
//                isEditar = false
//                posicion = -1
//            }
//        }
//    }
//
//    override fun onItemEditar(posicion: Int, elemento: Nombre) {
//        isEditar = true
//        this.posicion = posicion
//        binding.etNombreTipoAsignatura.setText(elemento.nombreTipoAsignatura)
//        binding.etDescripcion.setText(elemento.descripcion)
//
//    }
//
//    override fun onItemBorrar(position: Int) {
//        // Asumiendo que tu adapter tiene un método removeItem
//        mAdapter.removeItem(position)
//    }
//
//    companion object {
//        fun newInstance() = CrudFragment()
//    }
//}
