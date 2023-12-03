package com.example.appratingsoft.ui.crudAsignatura

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ratingsoft.data.Model.send.tipoAsignaturaSend
import com.example.ratingsoft.data.Model.send.UserAdmin
class AsignaturaModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text

    private val userById = MutableLiveData<tipoAsignaturaSend>()
    val user: LiveData<tipoAsignaturaSend> get() = userById

    private val _deleteUserResult = MutableLiveData<Boolean>()
    val deleteUserResult: LiveData<Boolean> get() = _deleteUserResult

    private val _updateProfileResult = MutableLiveData<Boolean>()
    val updateProfileResult: LiveData<Boolean> get() = _updateProfileResult

    init {
        val userId = UserAdmin.getUserId()
        Log.e("IDUSER", "${userId}")
    }

    fun fetchUserProfile() {
        val userId = UserAdmin.getUserId()
    }

}
