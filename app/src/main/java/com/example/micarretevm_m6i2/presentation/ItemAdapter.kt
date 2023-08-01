package com.example.micarretevm_m6i2.presentation


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.micarretevm_m6i2.data.local.Item
import com.example.micarretevm_m6i2.databinding.ItemLayoutBinding

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val listItem = mutableListOf<Item>()
    lateinit var binding: ItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)

        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = listItem[position]
        holder.bind(item)
    }

    class ItemViewHolder(val v: ItemLayoutBinding) : RecyclerView.ViewHolder(v.root) {

        fun bind(item: Item){
            v.tztNombew.text = item.nombre
            v.txtCantidad.text = item.cantidad.toString()
            v.txtPrecio.text = item.precio.toString()

            v.txtTotal.text = (item.precio * item.cantidad).toString()
        }
    }
}