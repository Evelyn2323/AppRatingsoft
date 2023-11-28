package com.example.appratingsoft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appratingsoft.databinding.ActivityPersonasBinding
import com.example.appratingsoft.databinding.ActivityTipoAsignaturasBinding

class personas_activity : AppCompatActivity() {
    private lateinit var binding: ActivityPersonasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personas)
    }
}