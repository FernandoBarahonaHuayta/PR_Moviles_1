package com.josue.apppizzeria

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.josue.apppizzeria.databinding.ActivityMainBinding
import com.josue.apppizzeria.databinding.ActivityPagoBinding
import java.text.DecimalFormat

class Pago : AppCompatActivity() {

    private lateinit var binding: ActivityPagoBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#E0E0E0")

        val name = intent.extras!!.getString("nombreProduct")
        val cantidad = intent.extras!!.getInt("monto")
        val total = intent.extras!!.getDouble("total")
        val salsaybebidas = intent.extras!!.getString("salsasybebidas")
        val decimalFormat = DecimalFormat.getCurrencyInstance()

        binding.txtTotal.text = "$name \n Cantidad: $cantidad \n Salsas Y Bebidas: $salsaybebidas \n Total: ${decimalFormat.format((total))}"

        binding.rbPagar.setOnClickListener{
            if (binding.rbTarjeta.isChecked) {
                val intent = Intent(this, PantallaAgradecimiento::class.java)
                startActivity(intent)
                Toast.makeText(this, "Pago con Tarjeta", Toast.LENGTH_SHORT).show()
            }else if (binding.rbPix.isChecked){
                binding.editarPix.visibility = View.VISIBLE
                val pix = binding.editarPix.text.toString()

                if (pix.isNotEmpty()) {
                    val intent = Intent(this, PantallaAgradecimiento::class.java)
                    intent.putExtra("usuarioPix", pix)
                    startActivity(intent)
                    Toast.makeText(this, "Pago con Pix", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Rellena los campos", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}