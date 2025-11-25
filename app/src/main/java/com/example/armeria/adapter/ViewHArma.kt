package com.example.armeria.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.armeria.databinding.ItemArmaBinding
import com.example.armeria.models.Arma

class ViewHArma(view: View) : RecyclerView.ViewHolder(view) {
    private val binding: ItemArmaBinding

    init {
        binding = ItemArmaBinding.bind(view)
    }

    fun render(arma: Arma, onEditClick: (Arma) -> Unit, onDeleteClick: (Arma) -> Unit) {
        binding.txtviewName.text = arma.nombre
        binding.txtviewCategoria.text = arma.categoria
        binding.costeEuro.text = arma.coste

        Glide.with(itemView.context)
            .load(arma.imagen)
            .fitCenter()
            .into(binding.ivArma)

        binding.btnEdit.setOnClickListener { onEditClick(arma) }
        binding.btnDelete.setOnClickListener { onDeleteClick(arma) }
    }
}