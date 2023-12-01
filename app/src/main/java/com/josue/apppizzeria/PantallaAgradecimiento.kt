package com.josue.apppizzeria

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PantallaAgradecimiento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_agradecimiento)

        window.statusBarColor = Color.parseColor("#E0E0E0")
    }
}