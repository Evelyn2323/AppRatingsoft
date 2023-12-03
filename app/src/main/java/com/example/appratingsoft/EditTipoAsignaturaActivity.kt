package com.example.appratingsoft

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appratingsoft.databinding.ActivityEditPerfilBinding
import com.example.appratingsoft.databinding.ActivityTipoAsignaturasBinding
import com.example.ratingsoft.data.Model.send.tipoAsignaturaSend

class EditTipoAsignaturaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTipoAsignaturasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipoAsignaturasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener el objeto TipoAsignaturaSend de los extras del Intent
        val tipoAsignaturaSend = intent.getSerializableExtra("TIPO_ASIGNATURA") as tipoAsignaturaSend
//        ata class tipoAsignaturasSend (
//            val id:String,
//            val nombreTipoAsignatura:String,
//            val descripcion:String
//        )
        // Aquí puedes usar los datos de tipoAsignaturaSend para llenar tus vistas de edición
        binding.titleEditText.setText(tipoAsignaturaSend.nombreTipoAsignatura)
        binding.descriptionEditText.setText(tipoAsignaturaSend.descripcion)

        // Agrega el código necesario para manejar la edición y guardar los cambios
    }

}
