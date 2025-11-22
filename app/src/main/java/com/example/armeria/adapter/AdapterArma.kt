package com.example.armeria.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.armeria.R
import com.example.armeria.models.Arma


class AdapterArma(var listArmas: MutableList<Arma>): RecyclerView.Adapter<ViewHArma>() {

    override fun onCreateViewHolder(parent:ViewGroup, viewType: Int): ViewHArma {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layoutItemArma = R.layout.item_arma
        return ViewHArma(layoutInflater.inflate(layoutItemArma, parent, false))
    }


    override fun onBindViewHolder(holder: ViewHArma, position: Int) {
        holder.renderize( listArmas.get(position))
    }

    override fun getItemCount(): Int = listArmas.size





}

