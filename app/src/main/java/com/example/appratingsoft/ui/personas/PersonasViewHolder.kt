package com.example.appratingsoft.ui.personas

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.databinding.ItemCursosBinding
import com.example.appratingsoft.databinding.ItemPersonasBinding
import com.example.ratingsoft.data.Model.send.CursosSend
import com.example.ratingsoft.data.Model.send.PersonasSend


class PersonasViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding: ItemPersonasBinding = ItemPersonasBinding.bind(view)

    fun render(contentModel: PersonasSend) {
        binding.title.text = contentModel.name
        binding.description.text = contentModel.email

    }

    }

