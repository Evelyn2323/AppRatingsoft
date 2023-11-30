package com.example.appratingsoft.ui.crudTipoAsisgnatura

import com.google.gson.annotations.SerializedName

data class TipoAsignaturaCrudResponse(
    @SerializedName("listaUsuarios") var listaUsuarios: ArrayList<TipoAsignaturaCrud>
)
