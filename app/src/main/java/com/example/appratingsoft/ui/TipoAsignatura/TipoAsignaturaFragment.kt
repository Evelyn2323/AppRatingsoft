package com.example.appratingsoft.ui.TipoAsignatura

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.EditTipoAsignaturaActivity
import com.example.appratingsoft.R
import com.example.appratingsoft.databinding.FragmentCursosBinding
import com.example.ratingsoft.data.Model.bring.tipoAsignaturasBring

class TipoAsignaturaFragment : Fragment() {

    // Declaraciones de variables
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TipoAsignaturaAdapter
    private var _binding: FragmentCursosBinding? = null

    // Esta propiedad solo es válida entre onCreateView y onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Crear una instancia del ViewModel
        val tipoAsignaturaViewModel =
            ViewModelProvider(this)[TipoAsignaturaViewModel::class.java]

        // Inflar y obtener la vista raíz del fragmento
        _binding = FragmentCursosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Obtener una referencia al TextView en el diseño
        val textView: TextView = binding.textHome

        // Observar el texto del ViewModel y actualizar el TextView
        tipoAsignaturaViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar el RecyclerView y el adaptador
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Crear una instancia del ViewModel
        val tipoAsignaturaViewModel =
            ViewModelProvider(this)[TipoAsignaturaViewModel::class.java]

        // Observar los datos del ViewModel y actualizar el adaptador
        tipoAsignaturaViewModel.contentData.observe(viewLifecycleOwner) { tipoAsignaturaResponse ->
            tipoAsignaturaResponse?.let {
                adapter = TipoAsignaturaAdapter(it) { selectedTipoAsignatura ->
                    Log.e("SHIT", "${selectedTipoAsignatura.id}")
                    onItemSelected(selectedTipoAsignatura)
                }
                recyclerView.adapter = adapter
            }
        }

    }

    fun onItemSelected(tipoAsignaturaResponse: tipoAsignaturasBring) { // voy a ver lo que esta pasando esto aqui
        val intent = Intent(requireContext(), EditTipoAsignaturaActivity::class.java)
        intent.putExtra("TIPOASIGNATURA_ID", tipoAsignaturaResponse.id)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
