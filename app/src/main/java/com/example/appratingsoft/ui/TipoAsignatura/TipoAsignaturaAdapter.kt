package com.example.appratingsoft.ui.TipoAsignatura

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.R
import com.example.ratingsoft.data.Model.bring.tipoAsignaturasBring
import com.example.ratingsoft.data.Model.send.tipoAsignaturaSend


class TipoAsignaturaAdapter(private val contentList: List<tipoAsignaturasBring>, private val onClickListener:(tipoAsignaturasBring ) -> Unit) : RecyclerView.Adapter<TipoAsignaturaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  TipoAsignaturaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TipoAsignaturaViewHolder(layoutInflater.inflate(R.layout.item_tipoasignaturas, parent, false))
    }
    override fun getItemCount(): Int =  contentList.size

    override fun onBindViewHolder(holder: TipoAsignaturaViewHolder, position: Int) {
        val item = contentList[position]
        holder.render(item, onClickListener)
    }


    private var listaDeDatos: List<tipoAsignaturasBring> = listOf()

    fun setData(newData: List<tipoAsignaturasBring>) {
        listaDeDatos = newData
        notifyDataSetChanged()
    }


}


