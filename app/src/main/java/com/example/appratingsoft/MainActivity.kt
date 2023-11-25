package com.example.appratingsoft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // Llama a la función showSplashScreen después de la creación de la actividad
    showSplashScreen()
}

    private fun showSplashScreen() {
        // Cambia la vista a la pantalla de inicio (activity_splash.xml)
        setContentView(R.layout.activity_main)

        // Temporizador para la pantalla de inicio
        Handler().postDelayed({
            // Inicia la actividad principal después del tiempo especificado
            startActivity(Intent(this, LoginActivity::class.java)) //aqui crear menu para que pase alla
            finish() // Cierra la actividad actual para evitar volver a la pantalla de inicio
        }, 2000) // 2000 milisegundos (2 segundos) de tiempo de espera
    }
}