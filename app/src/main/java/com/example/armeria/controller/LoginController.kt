package com.example.armeria.controller

import com.example.armeria.dao.DaoUsuario
import com.example.armeria.objects_models.Session

class LoginController {
    fun login(username: String, pass: String): Boolean {
        val usuario = DaoUsuario.myDao.login(username.trim(), pass.trim())
        return if (usuario != null) {
            Session.usuarioLogueado = usuario
            true
        } else {
            false
        }
    }
}
