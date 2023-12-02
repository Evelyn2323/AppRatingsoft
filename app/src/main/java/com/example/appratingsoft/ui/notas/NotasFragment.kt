package com.example.appratingsoft.ui.notas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.R
import com.example.appratingsoft.databinding.FragmentNotasBinding

class NotasFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NotasAdapter

    private var _binding: FragmentNotasBinding? = null

    // Esta propiedad sólo es válida entre
    // onCreateView y onDestroyView

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inicializa el ViewModel asociado a este fragmento
        val notasViewModel =
            ViewModelProvider(this)[NotasViewModel::class.java]

        _binding = FragmentNotasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Configura el observador para actualizar el texto de un TextView
        val textView: TextView = binding.textHome
        notasViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configura la RecyclerView y su adaptador
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Inicializa el ViewModel nuevamente para obtener datos y observar cambios
        val notasViewModel = ViewModelProvider(this)[NotasViewModel::class.java]

        // Observa cambios en los datos del ViewModel y actualiza el adaptador de la RecyclerView
        notasViewModel.contentData.observe(viewLifecycleOwner) { newData ->
            adapter = NotasAdapter(newData)
            recyclerView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
