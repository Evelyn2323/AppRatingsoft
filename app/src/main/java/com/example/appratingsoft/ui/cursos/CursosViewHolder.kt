package com.example.appratingsoft.ui.cursos

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appratingsoft.databinding.ItemCursosBinding
import com.example.ratingsoft.data.Model.send.CursosSend

class CursosViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding: ItemCursosBinding = ItemCursosBinding.bind(view)

    // Función para mostrar los datos del modelo en la vista
    fun render(contentModel: CursosSend) {
        // Asignar el nombre del curso al TextView correspondiente en el layout
        binding.title.text = contentModel.nombre
        // Asignar la descripción del curso al TextView correspondiente en el layout
        binding.description.text = contentModel.descripcion

    }
}
