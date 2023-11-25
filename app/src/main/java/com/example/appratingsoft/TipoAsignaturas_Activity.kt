package com.example.appratingsoft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.core.util.PatternsCompat
import com.example.appratingsoft.ClassImport.PopupAlert
import com.example.appratingsoft.Conexion.ApiConexion
import com.example.appratingsoft.databinding.ActivityLoginBinding
import com.example.ratingsoft.data.Model.bring.loginBring
import com.example.ratingsoft.data.Model.send.UserAdmin
import com.example.ratingsoft.data.Model.send.loginSend
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TipoAsignaturas_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val toast = PopupAlert()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clickListener()

//        binding.Newcuenta.setOnClickListener {
//            toast.toastSuccess(this, "Senakitch", "Registro de usuario")
//            startActivity(Intent(this, activity_registro2::class.java))
//        }
//
//        binding.newcuenta.setOnClickListener{
//            toast.toastSuccess(this, "Senakitch", "Olvide mi contraseña")
//            startActivity(Intent(this, activity_registro2::class.java))
//        }

    }//Fin

    private fun clickListener() {
        binding.button.setOnClickListener{
            validate()
            hideKeyboard()
            getInputs()
        }
    }
    private fun getInputs() {
        val email = binding.Correo.text.toString()
        val password = binding.password.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty())
        {
            loginUser(email, password)
        }
        else
        {
            toast.toastWarning(this, "Campos incompletos", "Completa los campos")
        }

    }

    private fun loginUser(email: String, password: String) {
        if (isEmailValid(email)) {
            val loginBring = loginBring(email, password)
            val apiCall = ApiConexion.getApiService().loginUser(loginBring)
            apiCall.enqueue(object : Callback<loginSend> {
                override fun onResponse(call: Call<loginSend>, response: Response<loginSend>) {
                    if (response.isSuccessful) {
                        val loginResponse = response.body()
                        loginResponse?.let {
                            val userId = it.user.id
                            UserAdmin.setUserId(userId)
                            move()
                            finish()
                            Log.d("API_CALL", "Login successful. User ID: $userId")
                        }
                    } else {
                        toast.toastError(this@TipoAsignaturas_Activity, "Error", "Correo invalido")
                        Log.e("API_CALL", "Login API call failed. Response code: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<loginSend>, t: Throwable) {
                    toast.toastError(this@TipoAsignaturas_Activity, "Error", "Ha ocurrido un error inesperado " + t.localizedMessage)
                    Log.e("API_CALL", "Login API call failed. Error: ${t.localizedMessage}")
                }

            })
        } else {
            toast.toastError(this@TipoAsignaturas_Activity, "Error", "Correo inválido")
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }

    /**
     * Function by move to MainActivity
     */
    private fun move() {
        startActivity(Intent(this, MenuActivity::class.java))
        finish()
    }

    /**
     *  Validate email and password
     */
    private fun validate() {
        val result = arrayOf(validateEmail(), validatePassword())
        if (false in result) {
            return
        }
        // Si la validación es exitosa, cambia al nuevo layout.
        switchToNewLayout()
    }

    private fun switchToNewLayout() {
        val newLayout = layoutInflater.inflate(R.layout.activity_main, null)
        setContentView(newLayout)
    }


    private fun validateEmail():Boolean {
        val email = binding.Correo.text.toString()
        return if(email.isEmpty()){
            binding.Correo.error = "El campo del correo no puede estar vacio"
            false
        }else if(!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.Correo.error = "Por favor ingresa un correo valido"
            false
        } else {
            binding.Correo.error = null
            true
        }
    }

    private fun validatePassword(): Boolean {
        val password = binding.password.text.toString()
        return if(password.isEmpty())
        {
            binding.password.error = "El campo contraseña no debe estar vacio"
            false
        } else {
            binding.password.error = null
            true
        }
    }

    private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.viewRoot.windowToken, 0)
    }







}