package com.example.armeria.dao

import com.example.armeria.models.Usuario
import com.example.armeria.objects_models.UsuariosRepository

class DaoUsuario private constructor() {
    companion object {
        val myDao: DaoUsuario by lazy { DaoUsuario() }
    }

    fun login(username: String, pass: String): Usuario? {
        return UsuariosRepository.listUsuarios.find { it.username == username && it.password == pass }
    }
}
