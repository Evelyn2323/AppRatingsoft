package com.example.appratingsoft.ui.cursos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.R
import com.example.appratingsoft.ui.notas.NotasViewHolder
import com.example.ratingsoft.data.Model.send.CursosSend
import com.example.ratingsoft.data.Model.send.NotasSend


class CursosAdapter(private val contentList: List<CursosSend>) : RecyclerView.Adapter<CursosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CursosViewHolder(layoutInflater.inflate(R.layout.item_cursos, parent, false))
    }


    override fun getItemCount(): Int =  contentList.size

    override fun onBindViewHolder(holder: CursosViewHolder, position: Int) {
        val item = contentList[position]
        holder.render(item)
    }

}