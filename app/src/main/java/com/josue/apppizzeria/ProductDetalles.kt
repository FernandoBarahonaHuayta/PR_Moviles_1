package com.josue.apppizzeria

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.josue.apppizzeria.databinding.ActivityProductDetallesBinding
import java.text.DecimalFormat

class ProductDetalles : AppCompatActivity() {

    private lateinit var binding : ActivityProductDetallesBinding
    var cantidad = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetallesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#E0E0E0")

        val imgProduct = intent.extras!!.getInt("imgProduct")
        val nombreProduct = intent.extras!!.getString("nombreProduct")
        val precioProduct = intent.extras!!.getString("precioProduct")!!.toDouble()
        var newPrice = precioProduct
        val decimalFormat = DecimalFormat.getCurrencyInstance()

        binding.imgProduct.setBackgroundResource(imgProduct)
        binding.txtProductName.text ="$nombreProduct"
        binding.txtPrecio.text = decimalFormat.format(precioProduct)

        binding.btnAtras.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnMas.setOnClickListener {
            if(cantidad == 1) {
                binding.txtMonto.text = "2"
                newPrice += precioProduct
                cantidad = 2
            }else if (cantidad == 2) {
                binding.txtMonto.text = "3"
                newPrice += precioProduct
                cantidad = 3
            }
            binding.txtPrecio.text = decimalFormat.format(newPrice)

            }

        binding.btnMenos.setOnClickListener {
            if(cantidad == 3) {
                binding.txtMonto.text = "2"
                newPrice -= precioProduct
                cantidad = 2
            }else if (cantidad == 2) {
                binding.txtMonto.text = "1"
                newPrice -= precioProduct
                cantidad = 1
            }
            binding.txtPrecio.text = decimalFormat.format(newPrice)
        }

        binding.btnConfirmar.setOnClickListener{

            val mostaza = binding.rbMostaza
            val oregano = binding.rbOrgano
            val limonada = binding.rbLimonada
            val Cocakola = binding.rbCoca

            val SalsasYBebidas = when{
                mostaza.isChecked -> {
                    "Mostaza"
                }

                oregano.isChecked -> {
                    "Mostaza"
                }

                limonada.isChecked -> {
                    "Limonada"
                }

                Cocakola.isChecked -> {
                    "Coca"
                }

                        else -> {
                            ""
                        }
            }

            val intent = Intent(this,Pago::class.java)
            intent.putExtra("nombreProduct",nombreProduct)
            intent.putExtra("monto",cantidad)
            intent.putExtra("total",newPrice)
            intent.putExtra("salsasybebidas", SalsasYBebidas)
            startActivity(intent)

        }

        }

    }
