package com.example.armeria.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.armeria.R
import com.example.armeria.models.Arma

class AdapterArma(
    private var armas: MutableList<Arma>,
    private val onEditClick: (Arma) -> Unit,
    private val onDeleteClick: (Arma) -> Unit
) : RecyclerView.Adapter<ViewHArma>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHArma {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_arma, parent, false)
        return ViewHArma(view)
    }

    override fun onBindViewHolder(holder: ViewHArma, position: Int) {
        holder.render(armas[position], onEditClick, onDeleteClick)
    }

    override fun getItemCount(): Int = armas.size
}