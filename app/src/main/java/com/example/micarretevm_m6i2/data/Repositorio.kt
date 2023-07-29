package com.example.micarretevm_m6i2.data

import androidx.lifecycle.LiveData
import com.example.micarretevm_m6i2.data.local.Item
import com.example.micarretevm_m6i2.data.local.ItemDao

class Repositorio(private val itemDao: ItemDao) {
    suspend fun insertItem(item: Item){
        itemDao.insertItem(item) //insertar tarea
    }

    fun cargarItem(): LiveData<List<Item>>{
        return itemDao.getAllItems() //obtener datos
    }
}