package com.josue.apppizzeria.listitems

import com.josue.apppizzeria.R
import com.josue.apppizzeria.modelo.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Products {

    private val _productList = MutableStateFlow<MutableList<Product>>(mutableListOf())
    private val  productListFlow: StateFlow<MutableList<Product>> = _productList

    fun getProducts(): Flow<MutableList<Product>>{
        val productList: MutableList<Product> = mutableListOf(
            Product(
                imgProduct = R.drawable.cheese_pizza,
                nombreProduct = "Pizza de Queso",
                precioProduct = "20.50"
            ),
            Product(
                imgProduct = R.drawable.mixed_pizza,
                nombreProduct = "Pizza Mixta",
                precioProduct = "25.90"
            ),
            Product(
                imgProduct = R.drawable.salmon_pizza,
                nombreProduct = "Pizza de Salmon",
                precioProduct = "14.00"
            ),
            Product(
                imgProduct = R.drawable.classic_pizza,
                nombreProduct = "Pizza Clasica",
                precioProduct = "21.50"
            ),
            Product(
                imgProduct = R.drawable.cheese_pizza,
                nombreProduct = "Pizza de Queso",
                precioProduct = "20.50"
            )
        )
        _productList.value = productList
        return productListFlow
    }

}