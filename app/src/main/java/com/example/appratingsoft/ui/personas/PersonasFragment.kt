package com.example.appratingsoft.ui.personas

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
import com.example.appratingsoft.databinding.FragmentPersonasBinding

class PersonasFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PersonasAdapter

    private var _binding: FragmentPersonasBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inicializa el ViewModel para este fragmento
        val personasViewModel =
            ViewModelProvider(this)[PersonasViewModel::class.java]

        // Infla y vincula la vista del fragmento
        _binding = FragmentPersonasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Configura el observador para actualizar el TextView cuando cambien los datos del ViewModel
        val textView: TextView = binding.textHome
        personasViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configura el RecyclerView y su LayoutManager
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Obtiene el ViewModel para este fragmento
        val personasViewModel = ViewModelProvider(this)[PersonasViewModel::class.java]

        // Observa los cambios en los datos y actualiza el adaptador del RecyclerView
        personasViewModel.contentData.observe(viewLifecycleOwner) { newData ->
            adapter = PersonasAdapter(newData)
            recyclerView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
