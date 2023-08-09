package org.demre.ei8razasperros.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.demre.ei8razasperros.data.local.RazaEntity
import org.demre.ei8razasperros.databinding.ItemRazasBinding

class AdapterRazas : RecyclerView.Adapter<AdapterRazas.ItemRazasViewHolder>() {

    lateinit var binding: ItemRazasBinding
    private val listItemRazas = mutableListOf<RazaEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRazasViewHolder {
        binding = ItemRazasBinding.inflate(LayoutInflater.from(parent.context),parent, false)

        return ItemRazasViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemRazas.size
    }

    override fun onBindViewHolder(holder: ItemRazasViewHolder, position: Int) {
        val raza = listItemRazas[position]
        holder.bind(raza)
    }

    fun setData(raza: List<RazaEntity>){
        this.listItemRazas.clear()
        this.listItemRazas.addAll(raza)
        notifyDataSetChanged()
    }

    class ItemRazasViewHolder(val razasVistas: ItemRazasBinding): RecyclerView.ViewHolder(razasVistas.root) {

        fun bind(raza: RazaEntity){
            razasVistas.tvRaza.text = raza.raza
        }

    }

}