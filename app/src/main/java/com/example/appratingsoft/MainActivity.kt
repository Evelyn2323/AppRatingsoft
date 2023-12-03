package com.example.appratingsoft

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.PopupMenu

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Llama a la función showSplashScreen después de la creación de la actividad
        showSplashScreen()
    }

    private fun showSplashScreen() {
        // Temporizador para la pantalla de inicio
        Handler().postDelayed({
            // Inicia la actividad principal después del tiempo especificado
            startActivity(Intent(this, LoginActivity::class.java))
            finish() // Cierra la actividad actual para evitar volver a la pantalla de inicio
        }, 2000) // 2000 milisegundos (2 segundos) de tiempo de espera
    }



    private fun changeToNightMode() {
        // Cambia al modo noche
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        recreate()
    }

    private fun exitApplication() {
        // Sale de la aplicación
        finish()
    }

}
