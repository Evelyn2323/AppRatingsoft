package com.example.appratingsoft.ui.personas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.R
import com.example.ratingsoft.data.Model.send.PersonasSend




class PersonasAdapter(private val contentList: List<PersonasSend>) : RecyclerView.Adapter<PersonasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  PersonasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PersonasViewHolder(layoutInflater.inflate(R.layout.item_personas, parent, false))
    }


    override fun getItemCount(): Int =  contentList.size

    override fun onBindViewHolder(holder: PersonasViewHolder, position: Int) {
        val item = contentList[position]
        holder.render(item)
    }

}