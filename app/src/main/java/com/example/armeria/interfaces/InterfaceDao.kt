package com.example.armeria.interfaces

import com.example.armeria.models.Arma

interface InterfaceDao {
    fun getDataArmas(): List<Arma>
}