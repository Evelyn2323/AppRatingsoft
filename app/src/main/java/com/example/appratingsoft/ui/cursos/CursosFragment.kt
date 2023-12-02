package com.example.appratingsoft.ui.cursos

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
import com.example.appratingsoft.databinding.FragmentCursosBinding
import com.example.appratingsoft.ui.notas.NotasViewModel

class CursosFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CursosAdapter

    private var _binding: FragmentCursosBinding? = null

    // Esta propiedad es solo válida entre onCreateView y onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inicializar el ViewModel específico para Cursos
        val cursosViewModel =
            ViewModelProvider(this)[CursosViewModel::class.java]

        _binding = FragmentCursosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        cursosViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Obtener el ViewModel específico para Cursos
        val cursosViewModel = ViewModelProvider(this)[CursosViewModel::class.java]

        // Observar los cambios en los datos y actualizar el adaptador
        cursosViewModel.contentData.observe(viewLifecycleOwner) { newData ->
            adapter = CursosAdapter(newData)
            recyclerView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
