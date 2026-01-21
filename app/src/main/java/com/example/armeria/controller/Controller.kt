package com.example.armeria.controller

import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.armeria.adapter.AdapterArma
import com.example.armeria.dao.DaoArmas
import com.example.armeria.models.Arma

class Controller(private val context: Context, private val recyclerView: RecyclerView) {

    private var listaDeArmas: MutableList<Arma> = mutableListOf()
    private lateinit var adapter: AdapterArma

    fun init(onEditClick: (Arma) -> Unit, onItemClick: (Int) -> Unit) {
        listaDeArmas = DaoArmas.myDao.getDataArmas().toMutableList()
        adapter = AdapterArma(
            armas = listaDeArmas,
            onEditClick = onEditClick,
            onDeleteClick = { arma ->
                deleteArma(arma)
            },
            onItemClick = onItemClick
        )
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    fun addArma(arma: Arma) {
        listaDeArmas.add(arma)
        adapter.notifyItemInserted(listaDeArmas.size - 1)
    }

    fun updateArma(updatedArma: Arma) {
        val position = listaDeArmas.indexOfFirst { it.nombre == updatedArma.nombre }
        if (position != -1) {
            listaDeArmas[position] = updatedArma
            adapter.notifyItemChanged(position)
        }
    }

    private fun deleteArma(arma: Arma) {
        val position = listaDeArmas.indexOf(arma)
        if (position != -1) {
            listaDeArmas.removeAt(position)
            adapter.notifyItemRemoved(position)
            Toast.makeText(context, "${arma.nombre} eliminada", Toast.LENGTH_SHORT).show()
        }
    }
}
