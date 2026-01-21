package com.example.armeria.models

class Arma(
    var nombre: String,
    var categoria: String,
    var coste: String,
    var imagen: String,
    var caracteristicas: String = ""
) {
    override fun toString(): String {
        return "Arma(nombre='$nombre', categoria='$categoria', coste='$coste', imagen='$imagen', caracteristicas='$caracteristicas')"
    }
}
