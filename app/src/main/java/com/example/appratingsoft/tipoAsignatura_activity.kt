package com.example.appratingsoft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appratingsoft.databinding.ActivityTipoAsignaturasBinding
import com.example.appratingsoft.ui.TipoAsignatura.TipoAsignaturaViewHolder
import com.example.appratingsoft.ui.TipoAsignatura.TipoAsignaturaViewModel
import com.example.appratingsoft.ui.home.HomeViewModel

class tipoAsignatura_activity : AppCompatActivity() {
    private lateinit var binding: ActivityTipoAsignaturasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipoAsignaturasBinding.inflate(layoutInflater)
        // Establece el diseño de la actividad a partir del archivo de diseño activity_cursos

        setContentView(binding.root)

    }

}