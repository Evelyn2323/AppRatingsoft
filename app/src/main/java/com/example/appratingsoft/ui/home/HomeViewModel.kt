package com.example.appratingsoft.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    // Usando MutableLiveData para que el valor pueda ser cambiado
    private val _text1 = MutableLiveData<String>().apply {
        value = "Tragment" // Valor inicial
    }

    // Exponiendo LiveData para que las actividades o fragmentos puedan observar los cambios
    val text: LiveData<String> = _text1
}
