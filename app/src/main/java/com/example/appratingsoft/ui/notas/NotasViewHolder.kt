package com.example.appratingsoft.ui.notas

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.databinding.ItemNotasBinding
import com.example.ratingsoft.data.Model.send.NotasSend

class NotasViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // Binding para acceder a las vistas en el diseño del elemento de notas
    private val binding: ItemNotasBinding = ItemNotasBinding.bind(view)


    fun render(contentModel: NotasSend) {
        // Asigna los valores del modelo a los elementos de la interfaz de usuario

        binding.description.text = contentModel.descripcion
        binding.detalle.text = contentModel.detalle
        binding.fecha.text = contentModel.fecha
        binding.valor.text = contentModel.valor

    }
}
