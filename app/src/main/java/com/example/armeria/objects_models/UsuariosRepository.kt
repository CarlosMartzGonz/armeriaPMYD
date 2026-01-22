package com.example.armeria.objects_models

import com.example.armeria.models.Usuario

object UsuariosRepository {
    val listUsuarios: List<Usuario> = listOf(
        Usuario("admin", "1234", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRD41FVYIkCGUt1NV9V6FZ1vZx3NdcCK0QQPA&s", "admin@armeria.com", "Administrador"),
        Usuario("usuario", "0000", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOUpQ0yJ-GLCDwMUYymx931h0RWBEheBfF6g&s", "usuario@armeria.com", "Usuario")
    )
}