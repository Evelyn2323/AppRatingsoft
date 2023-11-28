package com.example.appratingsoft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appratingsoft.databinding.ActivityNotasBinding
import com.example.appratingsoft.databinding.ActivityTipoAsignaturasBinding

class notas_activity : AppCompatActivity() {
    private lateinit var binding: ActivityNotasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas)
    }
}