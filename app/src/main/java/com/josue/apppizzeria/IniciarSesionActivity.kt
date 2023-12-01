package com.josue.apppizzeria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputLayout

class IniciarSesionActivity : AppCompatActivity() {
    private lateinit var txtcorreo:TextInputLayout
    private lateinit var txtconta:TextInputLayout

    private lateinit var correo:String
    private lateinit var contra:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)
    }
}