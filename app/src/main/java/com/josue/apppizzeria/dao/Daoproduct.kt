package com.josue.apppizzeria.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

import com.josue.apppizzeria.modelo.Product
@Dao
interface Daoproduct {
    @Query("SELECT * FROM Product")
    suspend fun productsSel(): List<Product>
    @Insert
    suspend fun productsIns(vararg product: Product)
    @Query("SELECT* FROM Product WHERE imgProduct = :imgProduct")
    suspend fun productsGet(imgProduct:Int):Product
    @Update
    suspend fun productsUpd(product: Product)
    @Delete
    suspend fun productsDel(product: Product)
}