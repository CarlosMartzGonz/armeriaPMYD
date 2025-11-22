package com.example.armeria.controller

import android.content.Context
import android.widget.Toast
import com.example.armeria.MainActivity
import com.example.armeria.adapter.AdapterArma
import com.example.armeria.dao.DaoArmas
import com.example.armeria.models.Arma



class Controller(val  context: Context) {
    lateinit var listArmas: MutableList<Arma>

    init {
        initData()
    }
    fun initData() {
        listArmas = DaoArmas.myDao.getDataArmas().toMutableList()
    }
    fun logOut(){
        Toast.makeText(context, "He mostrado los datos en pantalla", Toast.LENGTH_SHORT).show()
        listArmas.forEach {
            println(it)
        }
    }

    fun setAdapter(){
        val myActivity = context as MainActivity
        myActivity.binding.myRecyclerView.adapter = AdapterArma(listArmas)

    }

}