package com.example.armeria.models

class Usuario(
    var username: String,
    var password: String,
    var imagen: String
) {
    override fun toString(): String {
        return "Usuario: $username"
    }
}
