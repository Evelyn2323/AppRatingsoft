package com.example.appratingsoft.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    // MutableLiveData para almacenar el texto que se mostrará en la interfaz de usuario
    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment" // Valor predeterminado inicial
    }

    // LiveData expuesto para que la interfaz de usuario pueda observar los cambios
    val text: LiveData<String> = _text
}
