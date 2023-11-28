package com.example.appratingsoft.ui.notas

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.databinding.ItemNotasBinding
import com.example.ratingsoft.data.Model.send.CursosSend
import com.example.ratingsoft.data.Model.send.NotasSend


class NotasViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding: ItemNotasBinding = ItemNotasBinding.bind(view)

    fun render(contentModel: NotasSend){
        binding.title.text = contentModel.fecha
        binding.description.text = contentModel.descripcion
        binding.title.text = contentModel.valor
        binding.title.text = contentModel.detalle


    }

    }

