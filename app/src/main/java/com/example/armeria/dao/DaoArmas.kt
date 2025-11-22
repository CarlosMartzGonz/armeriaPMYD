package com.example.armeria.dao

import com.example.armeria.interfaces.InterfaceDao
import com.example.armeria.models.Arma
import com.example.armeria.objects_models.Repository

class DaoArmas private constructor(): InterfaceDao {
    companion object{
        val myDao: DaoArmas by lazy {
            DaoArmas()
        }
    }

    override fun getDataArmas(): List<Arma> = Repository.listArmas

}