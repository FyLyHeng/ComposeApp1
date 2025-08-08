package com.fylyheng.composeapp1.movie_app.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.fylyheng.composeapp1.movie_app.retofit.movie.Movie
import com.fylyheng.composeapp1.movie_app.retofit.movie.MovieRepository
import kotlinx.coroutines.launch


class MovieViewModel(repository: MovieRepository) : ViewModel() {

    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    var movieFromApi by mutableStateOf<List<Movie>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            try {

                //fetch data from api
                movieFromApi = repository.getPopularMovieFromApi()

                //update state
                movies = movieFromApi

            } catch (e: Exception){
                //get from room
            }
        }
    }
}


class MovieViewModelFactory (private val movieRepository: MovieRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {

            @Suppress("UNCHECKED_CAST")
            return MovieViewModel(movieRepository) as T
        }
        throw IllegalArgumentException("Unknow View Model Class")

    }

}