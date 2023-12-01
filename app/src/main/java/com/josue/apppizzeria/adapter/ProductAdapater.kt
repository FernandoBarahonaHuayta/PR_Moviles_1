package com.josue.apppizzeria.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.josue.apppizzeria.ProductDetalles
import com.josue.apppizzeria.databinding.ProductItemBinding
import com.josue.apppizzeria.modelo.Product

class ProductAdapater(private  val context: Context, private val productList: MutableList<Product>):
    RecyclerView.Adapter<ProductAdapater.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val listItem = ProductItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return ProductViewHolder(listItem)
    }


    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.imgProduct.setBackgroundResource(productList[position].imgProduct)
        holder.nombreProduct.text = productList[position].nombreProduct
        holder.precioProduct.text = productList[position].precioProduct

        //Event Click
        holder.btnAgregar.setOnClickListener {
            val intent = Intent(context,ProductDetalles::class.java)
            intent.putExtra("imgProduct",productList[position].imgProduct)
            intent.putExtra("nombreProduct",productList[position].nombreProduct)
            intent.putExtra("precioProduct",productList[position].precioProduct)
            context.startActivity(intent)
        }

    }

    inner class ProductViewHolder(binding: ProductItemBinding): RecyclerView.ViewHolder(binding.root){
        val imgProduct = binding.imgProduct
        val nombreProduct = binding.txtNombre
        val precioProduct = binding.txtPrecio
        val btnAgregar = binding.btnAgregar
    }

}