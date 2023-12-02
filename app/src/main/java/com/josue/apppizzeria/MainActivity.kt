package com.josue.apppizzeria

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.josue.apppizzeria.adapter.ProductAdapater
import com.josue.apppizzeria.database.AppDatabase
import com.josue.apppizzeria.databinding.ActivityMainBinding
import com.josue.apppizzeria.listitems.Products
import com.josue.apppizzeria.modelo.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding
    private lateinit var productAdapater: ProductAdapater
    private val products = Products()
    private val producList: MutableList<Product> = mutableListOf()
    var clicked = false

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.parseColor("#E0E0E0")


        CoroutineScope(Dispatchers.IO).launch {
            products.getProducts().collectIndexed { index, value ->
                for (p in value){
                    producList.add(p)
                }
            }
        }
       lifecycleScope.launch {
            val  database = AppDatabase.getInstance(this@MainActivity)
            val datos = database.productDao().productsSel()
            database.productDao().productsIns(Product(0,"Pizza","12"))
            Log.d("BD_CIBER","Registros: ${datos.size}")
        }
        val recyclerViewProducts = binding.recyclerViewProducts
        recyclerViewProducts.layoutManager = GridLayoutManager(this,2)
        recyclerViewProducts.setHasFixedSize(true)
        productAdapater = ProductAdapater(this,producList)
        recyclerViewProducts.adapter = productAdapater

       binding.btnPizzas.setOnClickListener {
            clicked = true
            if (clicked){
                binding.btnPizzas.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btnPizzas.setTextColor(Color.WHITE)
                binding.recyclerViewProducts.visibility = View.VISIBLE
                binding.txtTodo.text ="Pizzas"

                }
            }
        }
    }
