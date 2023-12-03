package com.example.appratingsoft.ui.personas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.R
import com.example.ratingsoft.data.Model.send.PersonasSend

// Adaptador para el RecyclerView que muestra una lista de PersonasSend
class PersonasAdapter(private val contentList: List<PersonasSend>) : RecyclerView.Adapter<PersonasViewHolder>() {

    // Se llama cuando RecyclerView necesita un nuevo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  PersonasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        // Crea y devuelve una nueva instancia de PersonasViewHolder inflando el diseño del elemento de la lista
        return PersonasViewHolder(layoutInflater.inflate(R.layout.item_personas, parent, false))
    }

    // Devuelve el número total de elementos en el conjunto de datos
    override fun getItemCount(): Int =  contentList.size

    // Se llama para mostrar los datos en una posición específica
    override fun onBindViewHolder(holder: PersonasViewHolder, position: Int) {
        // Obtiene el objeto PersonasSend en la posición actual
        val item = contentList[position]
        // Llama al método render en el ViewHolder para mostrar los datos en la interfaz de usuario
        holder.render(item)
    }
}
