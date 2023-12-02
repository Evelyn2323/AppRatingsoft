package com.example.appratingsoft.ui.notas

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.databinding.ItemNotasBinding
import com.example.ratingsoft.data.Model.send.NotasSend

class NotasViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // Binding para acceder a las vistas en el diseño del elemento de notas
    private val binding: ItemNotasBinding = ItemNotasBinding.bind(view)

    // Función para mostrar los datos en las vistas del elemento de notas
    fun render(contentModel: NotasSend) {
        // Asignar los valores del modelo a las vistas correspondientes
        binding.fecha.text = contentModel.fecha
        binding.description.text = contentModel.descripcion
        binding.valor.text = contentModel.valor
        binding.detalle.text = contentModel.detalle
    }
}
