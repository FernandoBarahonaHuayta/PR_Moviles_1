package com.josue.apppizzeria.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.josue.apppizzeria.dao.Daoproduct
import com.josue.apppizzeria.modelo.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
        abstract fun productDao():Daoproduct

        companion object{
            @Volatile
            private var INSTANCE: AppDatabase? = null
            fun getInstance(context: Context): AppDatabase{
                return INSTANCE ?: synchronized(this)
                {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "ciber"
                    ).build()
                    INSTANCE = instance
                    instance
                }
            }


        }

}