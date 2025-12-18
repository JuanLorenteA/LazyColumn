package com.example.lazycolumn.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun EjLazyColumn(modifier: Modifier = Modifier) {
    val categorias = remember { getPeliculas() }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = modifier.fillMaxSize()
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            items(categorias) { categoria ->
                CategoriaItem(
                    categoria = categoria,
                    modifier = modifier,
                    onMovieClick = { pelicula ->
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Seleccionaste: ${pelicula.titulo}"
                            )
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun CategoriaItem(categoria: Categoria, onMovieClick: (Pelicula) -> Unit, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = categoria.nombre,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = categoria.descripcion,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {
            items(categoria.peliculas) { pelicula ->
                PeliculaItem(
                    pelicula = pelicula,
                    onClick = {onMovieClick(pelicula) }
                )
            }
        }
    }
}
@Composable
fun PeliculaItem(
    pelicula: Pelicula,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(end = 12.dp)
            .width(220.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = pelicula.imagen),
                contentDescription = pelicula.titulo,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
            )
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = pelicula.titulo,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1
                )
                Text(
                    text = "${pelicula.puntuacion}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }
    }
}