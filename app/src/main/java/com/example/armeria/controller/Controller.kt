package com.example.armeria.controller

import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.armeria.adapter.AdapterArma
import com.example.armeria.dao.DaoArmas
import com.example.armeria.models.Arma

class Controller(private val context: Context, private val recyclerView: RecyclerView) {

    private lateinit var adapter: AdapterArma

    fun init(onEditClick: (Arma) -> Unit, onDeleteClick: (Arma) -> Unit, onItemClick: (Int) -> Unit) {
        val listaDeArmas = DaoArmas.myDao.getDataArmas().toMutableList()
        adapter = AdapterArma(
            armas = listaDeArmas,
            onEditClick = onEditClick,
            onDeleteClick = onDeleteClick,
            onItemClick = onItemClick
        )
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    fun addArma(arma: Arma) {
        DaoArmas.myDao.addArma(arma)
        actualizarAdapter()
        recyclerView.smoothScrollToPosition(adapter.itemCount - 1)
    }

    fun updateArma(position: Int, arma: Arma) {
        DaoArmas.myDao.updateArma(position, arma)
        actualizarAdapter()
    }

    fun deleteArma(position: Int) {
        DaoArmas.myDao.deleteArma(position)
        actualizarAdapter()
        Toast.makeText(context, "Arma eliminada", Toast.LENGTH_SHORT).show()
    }

    fun getArmaPosition(arma: Arma): Int {
        return DaoArmas.myDao.getDataArmas().indexOf(arma)
    }

    fun getArmasCount(): Int {
        return DaoArmas.myDao.getDataArmas().size
    }

    fun actualizarDatos() {
        actualizarAdapter()
    }

    private fun actualizarAdapter() {
        val nuevaLista = DaoArmas.myDao.getDataArmas().toMutableList()
        adapter.actualizarLista(nuevaLista)
    }
}