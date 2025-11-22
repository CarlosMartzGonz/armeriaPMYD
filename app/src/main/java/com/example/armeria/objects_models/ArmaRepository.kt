package com.example.armeria.objects_models

import com.example.armeria.models.Arma

interface ArmaRepository {
    fun getArmas(): List<Arma>
}
