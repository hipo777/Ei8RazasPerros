package org.demre.ei8razasperros.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import org.demre.ei8razasperros.databinding.FragmentListadoRazasBinding

class ListadoRazas : Fragment() {

    lateinit var binding: FragmentListadoRazasBinding
    private val razaViewModel: RazaViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListadoRazasBinding.inflate(layoutInflater, container, false)
        initAdapter()
        razaViewModel.getAllRazas()
        return binding.root
    }

    private fun initAdapter() {
        val adapter = AdapterRazas()
        binding.recyclerView.adapter = adapter
        razaViewModel.razaLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }


}