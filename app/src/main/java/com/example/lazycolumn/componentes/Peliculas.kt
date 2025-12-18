package com.example.lazycolumn.componentes

import com.example.lazycolumn.R

fun getPeliculas(): List<Categoria>{
    return listOf(
        Categoria(
            "Acción",
            "Películas llenas de adrenalina",
            listOf(
                Pelicula("Mad Max", 8.1, R.drawable.mad_max),
                Pelicula("John Wick", 7.9, R.drawable.john_wick),
                Pelicula("Die Hard", 8.2, R.drawable.die_hard)
            )
        ),
        Categoria(
            "Comedia",
            "Para reír sin parar",
            listOf(
                Pelicula("Superbad", 7.6, R.drawable.superbad),
                Pelicula("The Mask", 6.9, R.drawable.the_mask),
                Pelicula("Step Brothers", 6.9, R.drawable.step_brothers)
            )
        ),
        Categoria(
            "Ciencia Ficción",
            "Viajes espaciales y futuros alternativos",
            listOf(
                Pelicula("Interstellar", 8.6, R.drawable.interstellar),
                Pelicula("Inception", 8.8, R.drawable.inception),
                Pelicula("Blade Runner", 8.1, R.drawable.blade_runner)
            )
        )
    )
}