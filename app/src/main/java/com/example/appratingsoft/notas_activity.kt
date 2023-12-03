package com.example.appratingsoft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appratingsoft.databinding.ActivityNotasBinding
import com.example.appratingsoft.databinding.ActivityTipoAsignaturasBinding

class notas_activity : AppCompatActivity() {
    private lateinit var binding: ActivityNotasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el diseño de la actividad a partir del archivo de diseño activity_cursos

        setContentView(R.layout.activity_notas)
    }
}