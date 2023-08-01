package com.example.micarretevm_m6i2.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.micarretevm_m6i2.R
import com.example.micarretevm_m6i2.databinding.FragmentListBinding
import kotlinx.coroutines.launch

class ListFragment : Fragment() {
    private val itemVm: ItemsViewModel by activityViewModels()
    lateinit var binding: FragmentListBinding
    val adapter = ItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater,container,false)
        initLista()
        initDelete()
        return binding.root
    }

    private fun initDelete() {
        binding.flotanteDelete.setOnClickListener() {
            viewLifecycleOwner.lifecycleScope.launch {
                itemVm.deleteDatoView()
                findNavController().navigate(R.id.action_listFragment_to_fragment_agregar)
            }
        }
    }

    private fun initLista() {
        itemVm.getAllItems().observe(viewLifecycleOwner){
            adapter.setData(it)
        }

        binding.recyclerView.adapter = adapter
    }
}