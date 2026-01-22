package com.example.armeria.models

class Usuario(
    var username: String,
    var password: String,
    var imagen: String,
    var email: String = "$username@armeria.com",
    var rol: String = "Usuario"
) {
    override fun toString(): String {
        return "Usuario: $username"
    }
}