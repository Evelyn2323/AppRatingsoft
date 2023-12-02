package com.example.appratingsoft.ui.cursos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.R
import com.example.appratingsoft.ui.notas.NotasViewHolder
import com.example.ratingsoft.data.Model.send.CursosSend
import com.example.ratingsoft.data.Model.send.NotasSend

class CursosAdapter(private val contentList: List<CursosSend>) : RecyclerView.Adapter<CursosViewHolder>() {

    // Esta función se llama cuando se necesita crear un nuevo ViewHolder.
    // Se infla el diseño del elemento de la lista y se devuelve un nuevo ViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CursosViewHolder(layoutInflater.inflate(R.layout.item_cursos, parent, false))
    }

    // Esta función devuelve la cantidad total de elementos en la lista.
    override fun getItemCount(): Int = contentList.size

    // Esta función se llama para mostrar datos en un elemento específico de la lista.
    // Se llama para cada elemento visible en la pantalla.
    override fun onBindViewHolder(holder: CursosViewHolder, position: Int) {
        val item = contentList[position]
        holder.render(item)
    }
}
