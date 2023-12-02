package com.example.appratingsoft.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    // LiveData para almacenar el texto del fragmento de presentación de diapositivas
    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }

    // Propiedad de solo lectura para exponer el LiveData
    val text: LiveData<String> = _text
}
