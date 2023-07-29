package com.example.micarretevm_m6i2.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.micarretevm_m6i2.data.Repositorio
import com.example.micarretevm_m6i2.data.local.Item
import com.example.micarretevm_m6i2.data.local.ItemDataBase
import kotlinx.coroutines.launch

class ItemsViewModel(application: Application) : AndroidViewModel(application) {
    private val repositorio: Repositorio

    init {
        val dao = ItemDataBase.getDatabase(application).getItemsDao()
        repositorio = Repositorio(dao)
    }

    fun getAllItems(): LiveData<List<Item>> = repositorio.cargarItem()

    fun insertItem(nombre: String, precio: Int, cantidad: Int) = viewModelScope.launch {
        val item = Item(nombre, precio, cantidad)
        repositorio.insertItem(item)
    }
}