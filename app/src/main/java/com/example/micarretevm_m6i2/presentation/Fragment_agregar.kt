package com.example.micarretevm_m6i2.presentation

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.micarretevm_m6i2.R
import com.example.micarretevm_m6i2.data.local.Item
import com.example.micarretevm_m6i2.data.local.ItemDao
import com.example.micarretevm_m6i2.data.local.ItemDataBase
import com.example.micarretevm_m6i2.databinding.FragmentAgregarBinding


class Fragment_agregar : Fragment() {

    lateinit var binding : FragmentAgregarBinding
    private val itemVm: ItemsViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentAgregarBinding.inflate(layoutInflater,container,false)
        initListener()
        cargarItems()
        return binding.root
    }

    private fun initListener() {
        binding.btnGuardar.setOnClickListener {
            val nombre = binding.editTextNombre.text.toString()
            val precio = binding.editTextPrecio.text.toString().toDouble()
            val cantidad = binding.editTextCantidad.text.toString().toDouble()
            //itemVm.insertItem(nombre, precio, cantidad) <- se puede hacer directo sin usar el metodo.
            guardarItem(nombre,precio,cantidad)
            binding.editTextNombre.setText("")
            binding.editTextPrecio.setText("")
            binding.editTextCantidad.setText("")
            Toast.makeText(requireContext(), "Item Agregado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun guardarItem(nombre: String, precio: Double, cantidad: Double) {
        itemVm.insertItem(nombre, precio, cantidad)
    }

    private fun cargarItems() {

        itemVm.getAllItems().observe(viewLifecycleOwner){
            var aux = 0
            for(it in it){
                val precios = it.precio * it.cantidad
                aux = (aux + precios).toInt()
            }
            /*var contador = it.joinToString("\n") { it.precio.toString() }
            val listaPrecios = contador.split("\n").map { it.toDouble() }
            val sumaPrecios = listaPrecios.sum()
            */
            binding.txtResultado.text = "$ $aux"
        }

    }


}