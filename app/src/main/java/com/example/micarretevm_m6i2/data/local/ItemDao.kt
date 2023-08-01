package com.example.micarretevm_m6i2.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete

@Dao
interface ItemDao {
    @Insert
    suspend fun insertItem(item: Item)
    @Query("SELECT * FROM tabla_item order by id ASC")
    fun getAllItems(): LiveData<List<Item>>

    /*
    @Query("SELECT SUM(precio) FROM TABLA_ITEM")
    suspend fun getSumPrecio(): LiveData<List<Item>>
    */

    @Query("DELETE FROM tabla_item")
    suspend fun deleteDatos()
}