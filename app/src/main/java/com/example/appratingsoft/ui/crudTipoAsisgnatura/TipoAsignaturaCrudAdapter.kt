package com.example.appratingsoft.ui.crudTipoAsisgnatura

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.R

class TipoAsignaturaCrudAdapter(private val tipoAsignaturaList: List<TipoAsignaturaCrud>) :
    RecyclerView.Adapter<TipoAsignaturaCrudAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_usuario, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tipoAsignatura = tipoAsignaturaList[position]
        holder.tvId.text = tipoAsignatura.id
        holder.tvNombreTipoAsignatura.text = tipoAsignatura.nombreTipoAsignatura
        holder.tvDescripcion.text = tipoAsignatura.descripcion
    }

    override fun getItemCount(): Int {
        return tipoAsignaturaList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvId: TextView = itemView.findViewById(R.id.tvId)
        val tvNombreTipoAsignatura: TextView = itemView.findViewById(R.id.tvNombreTipoAsignatura)
        val tvDescripcion: TextView = itemView.findViewById(R.id.tVDescripcion)
    }
}
