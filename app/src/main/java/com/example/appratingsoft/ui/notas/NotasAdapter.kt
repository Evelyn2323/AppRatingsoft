package com.example.appratingsoft.ui.notas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.R
import com.example.ratingsoft.data.Model.send.NotasSend

// Un adaptador para la RecyclerView que muestra una lista de NotasSend
class NotasAdapter(private val contentList: List<NotasSend>) : RecyclerView.Adapter<NotasViewHolder>() {

    // Crea y devuelve una nueva instancia de NotasViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NotasViewHolder(layoutInflater.inflate(R.layout.item_notas, parent, false))
    }

    // Devuelve el número total de elementos en la lista
    override fun getItemCount(): Int = contentList.size

    // Vincula los datos de la lista a la vista del elemento en la posición dada
    override fun onBindViewHolder(holder: NotasViewHolder, position: Int) {
        val item = contentList[position]
        holder.render(item)
    }
}
