package com.example.appratingsoft.ui.personas

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.databinding.ItemPersonasBinding
import com.example.ratingsoft.data.Model.send.PersonasSend

class PersonasViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // Se utiliza el binding para acceder a las vistas del diseño del elemento de la lista
    private val binding: ItemPersonasBinding = ItemPersonasBinding.bind(view)

    // Método para renderizar los datos en la interfaz de usuario
    fun render(contentModel: PersonasSend) {
        // Establece los datos en las vistas correspondientes
        binding.title.text = contentModel.name
        binding.description.text = contentModel.email
    }
}
