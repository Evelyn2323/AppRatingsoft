package com.example.appratingsoft.ui.cursos

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appratingsoft.databinding.ItemCursosBinding
import com.example.ratingsoft.data.Model.send.CursosSend


class CursosViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding: ItemCursosBinding = ItemCursosBinding.bind(view)

    fun render(contentModel: CursosSend) {
        binding.title.text = contentModel.nombre
        binding.description.text = contentModel.descripcion

    }

    }

