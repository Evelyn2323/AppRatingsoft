package com.example.appratingsoft

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appratingsoft.R
import com.example.appratingsoft.ui.crudTipoAsisgnatura.TipoAsignaturaCrud
import com.example.appratingsoft.ui.crudTipoAsisgnatura.TipoAsignaturaCrudAdapter

class MainCrudActivity : AppCompatActivity() {

    private lateinit var etNombreTipoAsignatura: EditText
    private lateinit var etDescripcion: EditText
    private lateinit var btnAddUpdate: Button
    private lateinit var rvAsignatura: RecyclerView

    private lateinit var tipoAsignaturaList: MutableList<TipoAsignaturaCrud>
    private lateinit var tipoAsignaturaAdapter: TipoAsignaturaCrudAdapter

    // Agrega una variable para controlar si estás editando o agregando
    private var isEditing = false
    private var editingPosition = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_crud)

        etNombreTipoAsignatura = findViewById(R.id.etNombreTipoAsignatura)
        etDescripcion = findViewById(R.id.etDescripcion)
        btnAddUpdate = findViewById(R.id.btnAddUpdate)
        rvAsignatura = findViewById(R.id.rvAsignatura)

        tipoAsignaturaList = mutableListOf()
        tipoAsignaturaAdapter = TipoAsignaturaCrudAdapter(tipoAsignaturaList)
        rvAsignatura.layoutManager = LinearLayoutManager(this)
        rvAsignatura.adapter = tipoAsignaturaAdapter

        btnAddUpdate.setOnClickListener {
            // Lógica para agregar o actualizar TipoAsignatura
            val isValid = validateFields()
            if (isValid) {
                if (!isEditing) {
                    addTipoAsignatura()
                } else {
                    updateTipoAsignatura()
                }
            } else {
                // Muestra un mensaje de error si los campos no son válidos
            }
        }
    }

    private fun validateFields(): Boolean {
        return !(etNombreTipoAsignatura.text.isNullOrEmpty() || etDescripcion.text.isNullOrEmpty())
    }

    private fun addTipoAsignatura() {
        val nuevoTipoAsignatura = TipoAsignaturaCrud(
            id = "", // Debes generar el ID o ajustarlo según tu lógica
            nombreTipoAsignatura = etNombreTipoAsignatura.text.toString(),
            descripcion = etDescripcion.text.toString()
        )

        // Aquí debes hacer la llamada a Retrofit para agregar el TipoAsignatura
        // Puedes usar un CoroutineScope para hacer la llamada de manera asíncrona

        // Después de agregar el TipoAsignatura, actualiza la lista y limpia los campos
        tipoAsignaturaList.add(nuevoTipoAsignatura)
        tipoAsignaturaAdapter.notifyDataSetChanged()
        clearFields()
    }

    private fun updateTipoAsignatura() {
        // Aquí debes obtener el TipoAsignatura actual y actualizar sus propiedades
        // Después de actualizar el TipoAsignatura, actualiza la lista y limpia los campos
        if (editingPosition != -1) {
            val tipoAsignatura = tipoAsignaturaList[editingPosition]
            tipoAsignatura.nombreTipoAsignatura = etNombreTipoAsignatura.text.toString()
            tipoAsignatura.descripcion = etDescripcion.text.toString()

            // Aquí debes hacer la llamada a Retrofit para actualizar el TipoAsignatura
            // Puedes usar un CoroutineScope para hacer la llamada de manera asíncrona

            tipoAsignaturaAdapter.notifyDataSetChanged()
            clearFields()
            isEditing = false
            editingPosition = -1
            btnAddUpdate.text = "Agregar TipoAsignatura"
        }
    }

    private fun clearFields() {
        etNombreTipoAsignatura.text.clear()
        etDescripcion.text.clear()
    }
}
