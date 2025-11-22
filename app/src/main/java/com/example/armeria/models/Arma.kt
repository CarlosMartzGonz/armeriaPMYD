package com.example.armeria.models

class Arma(
    var nombre: String,
    var categoria: String,
    var coste: String,
    var imagen: String
) { override fun toString(): String {
        return "Arma: $nombre, Categoria: $categoria, Coste: $coste, UrlImagen: $imagen"
    }
}



