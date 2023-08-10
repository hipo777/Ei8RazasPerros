package org.demre.ei8razasperros.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import org.demre.ei8razasperros.databinding.FragmentDetallePerrosBinding

private const val ARG_PARAM1 = "id"

class DetallePerrosFragment : Fragment() {

    lateinit var binding: FragmentDetallePerrosBinding
    private val razaViewModel: RazaViewModel by activityViewModels()


    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetallePerrosBinding.inflate(layoutInflater, container, false)
        //initAdapter()
        razaViewModel.getDetallePerroVM(param1.toString())
        return binding.root
    }

    private fun initAdapter() {

    }


}