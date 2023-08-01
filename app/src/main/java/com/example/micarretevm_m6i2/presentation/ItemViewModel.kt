package com.example.micarretevm_m6i2.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.micarretevm_m6i2.data.Repositorio
import com.example.micarretevm_m6i2.data.local.Item
import com.example.micarretevm_m6i2.data.local.ItemDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemsViewModel(application: Application) : AndroidViewModel(application) {
    private val repositorio: Repositorio

    init {
        val dao = ItemDataBase.getDatabase(application).getItemsDao()
        repositorio = Repositorio(dao)
    }

    fun getAllItems(): LiveData<List<Item>> {
        return repositorio.cargarItem()
    }

    fun insertItem(nombre: String, precio: Double, cantidad: Double) = viewModelScope.launch {
        val item = Item(nombre, precio, cantidad)
        repositorio.insertItem(item)
    }

    suspend fun deleteDatoView() {
        viewModelScope.launch { Dispatchers.IO }
        repositorio.deleteDatos()
    }
}