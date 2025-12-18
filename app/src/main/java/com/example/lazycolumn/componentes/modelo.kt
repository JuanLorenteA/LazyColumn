package com.example.lazycolumn.componentes

import androidx.annotation.DrawableRes


data class Pelicula(
    val titulo: String,
    val puntuacion: Double,
    @DrawableRes val imagen: Int
)

data class Categoria(
    val nombre: String,
    val descripcion: String,
    val peliculas: List<Pelicula>
)
