package com.example.explora_me.model

data class Sitio(
    var id: Long = 0,
    val name: String,
    val descripcion: String = "",
    val ubicacion: String = "",
    val googleLink: String = "",
    var isFavorite: Boolean = false
)
