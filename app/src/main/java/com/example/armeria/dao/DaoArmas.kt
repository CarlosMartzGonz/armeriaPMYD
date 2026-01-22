package com.example.armeria.dao

import com.example.armeria.interfaces.InterfaceDao
import com.example.armeria.models.Arma
import com.example.armeria.objects_models.ArmasRepository

class DaoArmas private constructor(): InterfaceDao {
    companion object {
        val myDao: DaoArmas by lazy {
            DaoArmas()
        }
    }

    override fun getDataArmas(): List<Arma> = ArmasRepository.getArmas()

    fun addArma(arma: Arma) {
        ArmasRepository.addArma(arma)
    }

    fun updateArma(position: Int, arma: Arma) {
        ArmasRepository.updateArma(position, arma)
    }

    fun deleteArma(position: Int) {
        ArmasRepository.deleteArma(position)
    }
}