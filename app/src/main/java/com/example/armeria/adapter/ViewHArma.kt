package com.example.armeria.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.armeria.databinding.ItemArmaBinding
import com.example.armeria.models.Arma

class ViewHArma(view: View) : RecyclerView.ViewHolder(view) {
    lateinit var binding: ItemArmaBinding

    init {
        binding = ItemArmaBinding.bind(view)
    }

    fun renderize(arma: Arma) {
        binding.txtviewName.setText(arma.nombre)
        binding.txtviewCategoria.setText(arma.categoria)
        binding.costeEuro.setText(arma.coste)
        Glide
            .with(itemView.context)
            .load(arma.imagen)
            .fitCenter()
            .into(binding.ivArma)



    }


}