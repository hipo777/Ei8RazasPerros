package org.demre.ei8razasperros.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.demre.ei8razasperros.data.local.RazaDetalleEntity
import org.demre.ei8razasperros.databinding.ItemDetallePerroBinding

class AdapterDetalle: RecyclerView.Adapter<AdapterDetalle.DetallePerroViewHolder>() {

    lateinit var binding: ItemDetallePerroBinding
    private val listDetalleperro = mutableListOf<RazaDetalleEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetallePerroViewHolder {
        binding = ItemDetallePerroBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return DetallePerroViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listDetalleperro.size
    }

    override fun onBindViewHolder(holder: DetallePerroViewHolder, position: Int) {
        val perro = listDetalleperro[position]
        holder.bind(perro)
    }

    fun setDataDetalle(detalle : List<RazaDetalleEntity>){
        this.listDetalleperro.clear()
        this.listDetalleperro.addAll(detalle)
        notifyDataSetChanged()
    }

    class DetallePerroViewHolder(val perrovista: ItemDetallePerroBinding): RecyclerView.ViewHolder(perrovista.root){
        fun bind(detalle: RazaDetalleEntity){
            perrovista.imageDogsDetail.load(detalle.url)
        }
    }
}