package com.josue.apppizzeria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

    fun login(view: View)
    {
        var email = txtCorreo.editText?.text.toString()
        var password = txtPass.editText?.text.toString()
        // Toast.makeText(this,"$email - $password",Toast.LENGTH_SHORT).show()

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
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



}