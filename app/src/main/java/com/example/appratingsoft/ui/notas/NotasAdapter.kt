package com.example.appratingsoft.ui.notas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.R
import com.example.ratingsoft.data.Model.send.NotasSend


class NotasAdapter(private val contentList: List<NotasSend>) : RecyclerView.Adapter<NotasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  NotasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NotasViewHolder(layoutInflater.inflate(R.layout.item_notas, parent, false))
    }


    override fun getItemCount(): Int =  contentList.size

    override fun onBindViewHolder(holder: NotasViewHolder, position: Int) {
        val item = contentList[position]
        holder.render(item)
    }

}