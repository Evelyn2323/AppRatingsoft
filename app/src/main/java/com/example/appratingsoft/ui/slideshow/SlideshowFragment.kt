package com.example.appratingsoft.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.appratingsoft.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    // Variable para almacenar la referencia al binding
    private var _binding: FragmentSlideshowBinding? = null

    // Esta propiedad solo es válida entre onCreateView y onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // ViewModel asociado al fragmento
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        // Inflar el diseño utilizando el binding
        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Configurar el TextView con el texto del ViewModel
        val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Liberar la referencia al binding cuando se destruye la vista
        _binding = null
    }
}
