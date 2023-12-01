package com.josue.apppizzeria

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {

    //Valores globales
    private lateinit var txtCorreo:TextInputLayout
    private lateinit var txtPass:TextInputLayout
    //Valores para crear cuenta

    private lateinit var correo:String
    private lateinit var contra:String
    //Firebase
    private lateinit var auth:FirebaseAuth

    public override fun onStart() {
        super.onStart()
         val currentUser = auth.currentUser
        if(currentUser != null)
        {
            Toast.makeText(this,currentUser.email, Toast.LENGTH_SHORT).show()

            startActivity(Intent(this,MainActivity::class.java))

        }

    }
    //TAG
    companion object {
        private const val TAG = "PIZ_LOGIN"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        txtCorreo = findViewById(R.id.txt_Correo)
        txtPass = findViewById(R.id.txt_login)
        auth = Firebase.auth
    }

    @SuppressLint("SuspiciousIndentation")
    fun login(view: View)
    {
        if(!validar())
            return
            auth.signInWithEmailAndPassword(correo,contra).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {

                Log.d(TAG, "signInWithEmail:success")
                val user = auth.currentUser
                startActivity(Intent(this,MainActivity::class.java))
            } else {

                Log.w(TAG, "signInWithEmail:failure", task.exception)
                Toast.makeText(
                    baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()

            }
        }

    }

    fun sigoup(view: View)
    {
        if(!validar())
            return
        auth.createUserWithEmailAndPassword(correo,contra).addOnCompleteListener(this)
        {
            task ->
            if(task.isSuccessful)
            {
                Toast.makeText(this,"$correo - $contra registrado", Toast.LENGTH_SHORT).show()

            }
            else
            {
                Toast.makeText(baseContext,"Fallo al registar",Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun validar():Boolean
    {
        correo = txtCorreo.editText?.text.toString()
        if (TextUtils.isEmpty(correo))
        {
            txtCorreo.error="Ingresar correo"
            return false

        }else if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches())
        {
            txtCorreo.error = "Ingresar en formato de correo"
        }else
        {
            txtCorreo.error=null
        }

        contra = txtPass.editText?.text.toString()
        if (TextUtils.isEmpty(contra))
        {
            txtPass.error = "Ingresar contraseña"
            return false
        }else{
            txtPass.error=null
        }
        return true
    }
}