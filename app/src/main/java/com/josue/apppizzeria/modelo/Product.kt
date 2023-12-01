package com.josue.apppizzeria.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(

    @PrimaryKey(autoGenerate = true)
    val imgProduct: Int,
    @ColumnInfo
    val nombreProduct: String?,
    @ColumnInfo
    val precioProduct: String?
)