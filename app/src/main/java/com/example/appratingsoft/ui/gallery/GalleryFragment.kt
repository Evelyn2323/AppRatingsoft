package com.example.appratingsoft.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appratingsoft.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // Este bloque de código es solo válido entre onCreateView y onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Crear una instancia del ViewModel de la galería
        val galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)

        // Inflar el diseño del fragmento usando el enlace generado
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Obtener la referencia al TextView del diseño y observar cambios en el texto del ViewModel
        val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        // Devolver la vista inflada
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Limpiar la referencia al enlace cuando el fragmento está siendo destruido
        _binding = null
    }
}
