package com.fylyheng.composeapp1.movie_app.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fylyheng.composeapp1.movie_app.data.movie.Movie

@Composable
fun MovieList (movies: List<Movie>, innerPaddingValues: PaddingValues) {

    LazyColumn (modifier = Modifier.padding(innerPaddingValues)){

        items(movies) {
            MovieItem(it)
        }
    }

}