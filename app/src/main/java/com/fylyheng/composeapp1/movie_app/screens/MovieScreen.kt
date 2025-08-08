package com.fylyheng.composeapp1.movie_app.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.fylyheng.composeapp1.movie_app.view_model.MovieViewModel

@Composable
fun MovieScreen(viewModel: MovieViewModel, innerPaddingValues: PaddingValues) {

    val moviesList = viewModel.movies

    MovieList(moviesList, innerPaddingValues)
}